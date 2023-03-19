package cn.bobolaboratory.springboot.controller.BackStage;

import cn.bobolaboratory.springboot.service.BackStage.CaptchaService.CaptchaService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WhiteLeaf03
 */
@Api(tags = "验证码相关")
@RestController
@RequestMapping("/bs/api/captcha")
public class CaptchaController {
    private final CaptchaService captchaService;

    @Autowired
    public CaptchaController(CaptchaService captchaService) {
        this.captchaService = captchaService;
    }

    @ApiOperation(("获取验证码"))
    @GetMapping("")
    public ResponseResult getCaptcha() {
        return captchaService.getCaptcha();
    }
}
