package cn.bobolaboratory.springboot.service.BackStage.LoginStatusService;

import cn.bobolaboratory.springboot.entity.BackstageUser;
import cn.bobolaboratory.springboot.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface LoginStatusService {
    /**
     * 用户登录
     * @param backstageUser 含有用户名及密码
     * @return 返回登录结果
     */
    ResponseResult login(BackstageUser backstageUser);
}
