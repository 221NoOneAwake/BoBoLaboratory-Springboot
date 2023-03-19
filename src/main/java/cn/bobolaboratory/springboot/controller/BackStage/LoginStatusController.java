package cn.bobolaboratory.springboot.controller.BackStage;

import cn.bobolaboratory.springboot.dto.BackstageUserLoginRequest;
import cn.bobolaboratory.springboot.service.BackStage.LoginStatusService.LoginStatusService;
import cn.bobolaboratory.springboot.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WhiteLeaf03
 */
@Api(tags = "后台-登录")
@RestController
@RequestMapping("/bs/api/login")
public class LoginStatusController {
    private final LoginStatusService loginStatusService;

    @Autowired
    public LoginStatusController(LoginStatusService loginStatusService) {
        this.loginStatusService = loginStatusService;
    }

    @ApiOperation("后台用户登录")
    @PostMapping("")
    public ResponseResult login(@RequestBody BackstageUserLoginRequest backstageUserLoginRequest) {
        return loginStatusService.login(backstageUserLoginRequest);
    }
}
