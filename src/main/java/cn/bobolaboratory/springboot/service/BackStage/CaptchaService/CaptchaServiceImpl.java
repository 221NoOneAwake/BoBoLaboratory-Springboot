package cn.bobolaboratory.springboot.service.BackStage.CaptchaService;

import cn.bobolaboratory.springboot.utils.RedisCache;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class CaptchaServiceImpl implements CaptchaService {
    private final RedisCache redisCache;

    @Autowired
    public CaptchaServiceImpl(RedisCache redisCache) {
        this.redisCache = redisCache;
    }

    /**
     * 获取验证码
     * @return 返回身份码 验证码
     */
    @Override
    public ResponseResult getCaptcha() {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(180, 30, 6, 4);
        String identity = RandomUtil.randomString(16);
        Map<String, String> map = new HashMap<>();
        map.put("identity", identity);
        map.put("captchaBase64Data", lineCaptcha.getImageBase64Data());
        redisCache.setCacheObject("[Captcha]" + identity, lineCaptcha.getCode(), 5, TimeUnit.MINUTES);
        return ResponseResult.success(map);
    }
}
