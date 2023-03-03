package cn.bobolaboratory.springboot.controller.FrontDesk;

import cn.bobolaboratory.springboot.entity.NormalUser;
import cn.bobolaboratory.springboot.service.FrontDesk.NormalUser.NormalUserService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import io.swagger.annotations.Api;
import lombok.Setter;
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

    @Setter
    static class LoginData {
        String code;
    }

    @PostMapping("/login")
    public ResponseResult normalUserLogin(@RequestBody LoginData loginData) {
        return normalUserService.normalUserLogin(loginData.code);
    }

    @PostMapping("/register")
    public ResponseResult normalUserRegister(@RequestBody NormalUser normalUser) {
        return normalUserService.normalUserRegister(normalUser);
    }
}
