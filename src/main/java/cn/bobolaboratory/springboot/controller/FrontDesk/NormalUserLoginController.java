package cn.bobolaboratory.springboot.controller.FrontDesk;

import cn.bobolaboratory.springboot.entity.NormalUser;
import cn.bobolaboratory.springboot.service.FrontDesk.NormalUser.NormalUserService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/fd/api/login")
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

    @PostMapping("")
    public ResponseResult normalUserLogin(@RequestBody LoginData loginData) {
        return normalUserService.normalUserLogin(loginData.code);
    }

}
