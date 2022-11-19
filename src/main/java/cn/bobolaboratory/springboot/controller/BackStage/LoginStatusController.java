package cn.bobolaboratory.springboot.controller.BackStage;

import cn.bobolaboratory.springboot.entity.BackstageUser;
import cn.bobolaboratory.springboot.service.BackStage.LoginStatusService.LoginStatusService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WhiteLeaf03
 */
@RestController
@RequestMapping("/bs/api/login")
public class LoginStatusController {
    private final LoginStatusService loginStatusService;

    @Autowired
    public LoginStatusController(LoginStatusService loginStatusService) {
        this.loginStatusService = loginStatusService;
    }

    @PostMapping("")
    public ResponseResult login(@RequestBody BackstageUser backstageUser) {
        System.out.println(backstageUser.toString());
        return loginStatusService.login(backstageUser);
    }
}
