package cn.bobolaboratory.springboot.service.FrontDesk.NormalUser;

import cn.bobolaboratory.springboot.config.GlobalConfig;
import cn.bobolaboratory.springboot.dto.NormalUserLoginRequest;
import cn.bobolaboratory.springboot.dto.NormalUserRegisterRequest;
import cn.bobolaboratory.springboot.entity.NormalUser;
import cn.bobolaboratory.springboot.mapper.NormalUserMapper;
import cn.bobolaboratory.springboot.security.AuthNormalUser;
import cn.bobolaboratory.springboot.utils.JwtUtil;
import cn.bobolaboratory.springboot.utils.RedisCache;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class NormalUserServiceImpl implements NormalUserService {

    private final NormalUserMapper normalUserMapper;
    private final RedisCache redisCache;
    private final GlobalConfig globalConfig;

    @Autowired
    public NormalUserServiceImpl(NormalUserMapper normalUserMapper, RedisCache redisCache, GlobalConfig globalConfig) {
        this.normalUserMapper = normalUserMapper;
        this.redisCache = redisCache;
        this.globalConfig = globalConfig;
    }

    /**
     * 根据code进行用户登录
     * @param normalUserLoginRequest 用户临时登录凭证
     * @return 返回登录结果
     */
    @Override
    public ResponseResult normalUserLogin(NormalUserLoginRequest normalUserLoginRequest) {
        //发送get请求到微信服务器，换区登录用户信息
        RestTemplate restTemplate = new RestTemplate();
        //防止get乱码 设置编码格式
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={code}&grant_type=authorization_code";
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("appid", globalConfig.getAppid());
        requestMap.put("secret", globalConfig.getSecret());
        requestMap.put("code", normalUserLoginRequest.getCode());

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, requestMap);

        if (!responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            throw new RuntimeException("Auth request failed");
        }

        JSONObject jsonObject = JSONObject.parseObject(responseEntity.getBody());
        if (jsonObject == null) {
            throw new NullPointerException("Auth response body is null");
        }
        String openid = jsonObject.getString("openid");
        if (openid == null) {
            Integer errcode = jsonObject.getInteger("errcode");
            String errmsg = jsonObject.getString("errmsg");
            throw new RuntimeException(errcode + "," + errmsg);
        }

        NormalUser user;
        user = normalUserMapper.queryNormalUserByOpenid(openid);
        if (user == null) {
            normalUserMapper.addNormalUser(openid);
            NormalUser normalUser = normalUserMapper.queryNormalUserByOpenid(openid);
            Map<String, String> map = new HashMap<>();
            redisCache.setCacheObject("[NUser]id:" + normalUser.getId(), normalUser, 90, TimeUnit.MINUTES);
            String token = JwtUtil.createJwt(normalUser.getId().toString());
            map.put("msg", "用户尚未注册");
            map.put("token", token);
            return ResponseResult.success(map);
        }

        redisCache.setCacheObject("[NUser]id:" + user.getId(), user, 90, TimeUnit.MINUTES);
        String token = JwtUtil.createJwt(user.getId().toString());
        return ResponseResult.success(token);
    }

    /**
     * 新用户更新信息
     * @param normalUserRegisterRequest 新用户信息
     * @return 返回结果
     */
    @Override
    public ResponseResult normalUserRegister(NormalUserRegisterRequest normalUserRegisterRequest) {
        try {
            AuthNormalUser authNormalUser = (AuthNormalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            normalUserMapper.registerNormalUser(authNormalUser.getNormalUser().getId(), normalUserRegisterRequest);
            return ResponseResult.success();
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }
}
