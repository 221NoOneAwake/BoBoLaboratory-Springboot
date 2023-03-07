package cn.bobolaboratory.springboot.service.BackStage.CaptchaService;

import cn.bobolaboratory.springboot.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface CaptchaService {
    /**
     * 获取验证码
     * @return 返回身份码 验证码
     */
    ResponseResult getCaptcha();
}
