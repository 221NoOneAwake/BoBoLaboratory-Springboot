package cn.bobolaboratory.springboot.service.BackStage.LoginStatusService;

import cn.bobolaboratory.springboot.dto.BackstageUserLoginRequest;
import cn.bobolaboratory.springboot.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface LoginStatusService {
    /**
     * 用户登录
     * @param backstageUserLoginRequest 含有用户名及密码
     * @return 返回登录结果
     */
    ResponseResult login(BackstageUserLoginRequest backstageUserLoginRequest);
}
