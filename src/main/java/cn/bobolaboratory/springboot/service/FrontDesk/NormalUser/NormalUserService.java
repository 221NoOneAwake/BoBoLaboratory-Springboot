package cn.bobolaboratory.springboot.service.FrontDesk.NormalUser;

import cn.bobolaboratory.springboot.entity.NormalUser;
import cn.bobolaboratory.springboot.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface NormalUserService {

    /**
     * 根据code进行用户登录
     * @param code 用户临时登录凭证
     * @return 返回登录结果
     */
    ResponseResult normalUserLogin(String code);

    /**
     * 新用户注册
     * @param normalUser 新用户信息
     * @return 返回结果
     */
    ResponseResult normalUserRegister(NormalUser normalUser);
}
