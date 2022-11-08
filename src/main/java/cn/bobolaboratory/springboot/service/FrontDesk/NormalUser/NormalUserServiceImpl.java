package cn.bobolaboratory.springboot.service.FrontDesk.NormalUser;

import cn.bobolaboratory.springboot.entity.NormalUser;
import cn.bobolaboratory.springboot.mapper.NormalUserMapper;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NormalUserServiceImpl implements NormalUserService {

    private final NormalUserMapper normalUserMapper;

    @Autowired
    public NormalUserServiceImpl(NormalUserMapper normalUserMapper) {
        this.normalUserMapper = normalUserMapper;
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

        Map<String, Object> map = new HashMap<>();
        map.put("appid", "小程序id");
        map.put("secret", "小程序密钥");
        map.put("js_code", code);
        map.put("grant_type", "authorization_code");
        ResponseEntity<Object> forEntity = restTemplate.getForEntity("https://api.weixin.qq.com/sns/jscode2session", Object.class, map);
        JSONObject jsonObject;

        List<NormalUser> list = normalUserMapper.queryNormalUserByOpenid(code);
        if (list.size() == 0) {
            return new ResponseResult(3, "该用户尚未注册");
        } else {
            return ResponseResult.success(list.get(0));
        }
    }
}
