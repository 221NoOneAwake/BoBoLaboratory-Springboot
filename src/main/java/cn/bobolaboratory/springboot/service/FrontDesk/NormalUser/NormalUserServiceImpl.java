package cn.bobolaboratory.springboot.service.FrontDesk.NormalUser;

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

@Service
public class NormalUserServiceImpl implements NormalUserService {

    private final NormalUserMapper normalUserMapper;
    private final RedisCache redisCache;

    @Autowired
    public NormalUserServiceImpl(NormalUserMapper normalUserMapper, RedisCache redisCache) {
        this.normalUserMapper = normalUserMapper;
        this.redisCache = redisCache;
    }

    /**
     * 根据code进行用户登录
     * @param code 用户临时登录凭证
     * @return 返回登录结果
     */
    @Override
    public ResponseResult normalUserLogin(String code) {
        //发送get请求到微信服务器，换区登录用户信息
        RestTemplate restTemplate = new RestTemplate();
        //防止get乱码 设置编码格式
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={code}&grant_type=authorization_code";
        Map<String, String> requestMap = new HashMap<>();
        requestMap.put("appid", "wxca84b633d9875593");
        requestMap.put("secret", "7500ca9f8d22a56aa50fd61da8ab3f3e");
        requestMap.put("code", code);

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
            try {
                user = new NormalUser(openid);
            } catch (Exception e) {
                throw new RuntimeException("Save user error");
            }
            normalUserMapper.registerNormalUser(user);
            return ResponseResult.success("用户尚未注册");
        }

        redisCache.setObject("[NUser]id:" + user.getId(), user);
        String token = JwtUtil.createJwt(user.getId().toString());
        return ResponseResult.success(token);
    }

    /**
     * 新用户注册
     * @param normalUser 新用户信息
     * @return 返回结果
     */
    @Override
    public ResponseResult normalUserRegister(NormalUser normalUser) {
        try {
            AuthNormalUser authNormalUser = (AuthNormalUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            normalUser.setId(authNormalUser.getNormalUser().getId());
            normalUserMapper.updateNormalUserById(normalUser);
            return ResponseResult.success();
        } catch (RuntimeException e) {
            return ResponseResult.error(e.getMessage());
        }
    }
}
