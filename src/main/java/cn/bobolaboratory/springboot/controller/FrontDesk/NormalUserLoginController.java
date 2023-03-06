package cn.bobolaboratory.springboot.controller.FrontDesk;

import cn.bobolaboratory.springboot.dto.NormalUserLoginRequest;
import cn.bobolaboratory.springboot.dto.NormalUserRegisterRequest;
import cn.bobolaboratory.springboot.service.FrontDesk.NormalUser.NormalUserService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WhiteLeaf03
 */
@Api(tags = "前台-用户登录注册")
@RestController
@RequestMapping("/fd/api")
public class NormalUserLoginController {

    private final NormalUserService normalUserService;

    @Autowired
    public NormalUserLoginController(NormalUserService normalUserService) {
        this.normalUserService = normalUserService;
    }

    @PostMapping("/login")
    public ResponseResult normalUserLogin(@RequestBody NormalUserLoginRequest normalUserLoginRequest) {
        return normalUserService.normalUserLogin(normalUserLoginRequest);
    }

    @PostMapping("/register")
    public ResponseResult normalUserRegister(@RequestBody NormalUserRegisterRequest normalUserRegisterRequest) {
        return normalUserService.normalUserRegister(normalUserRegisterRequest);
    }
}
