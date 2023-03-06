package cn.bobolaboratory.springboot.service.FrontDesk.NormalUser;

import cn.bobolaboratory.springboot.dto.NormalUserLoginRequest;
import cn.bobolaboratory.springboot.dto.NormalUserRegisterRequest;
import cn.bobolaboratory.springboot.utils.ResponseResult;

/**
 * @author WhiteLeaf03
 */
public interface NormalUserService {

    /**
     * 根据code进行用户登录
     * @param normalUserLoginRequest 含用户临时登录凭证
     * @return 返回登录结果
     */
    ResponseResult normalUserLogin(NormalUserLoginRequest normalUserLoginRequest);

    /**
     * 新用户注册
     * @param normalUserRegisterRequest 新用户信息
     * @return 返回结果
     */
    ResponseResult normalUserRegister(NormalUserRegisterRequest normalUserRegisterRequest);
}
