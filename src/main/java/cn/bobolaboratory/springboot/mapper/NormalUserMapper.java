package cn.bobolaboratory.springboot.mapper;

import cn.bobolaboratory.springboot.dto.NormalUserRegisterRequest;
import cn.bobolaboratory.springboot.dto.NormalUserUpdateRequest;
import cn.bobolaboratory.springboot.entity.NormalUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author WhiteLeaf03
 */
@Mapper
public interface NormalUserMapper {

    /**
     * 根据openid查询用户信息
     * @param openid 用户微信openid
     * @return 返回查询获得的信息
     */
    NormalUser queryNormalUserByOpenid(String openid);


    /**
     * 获取所有学生数据
     * @return 返回查询获得的信息
     */
    List<NormalUser> queryAllNormalUser();

    /**
     * 更新学生信息
     * @param normalUserUpdateRequest 要更新的学生信息
     */
    void updateNormalUserById(NormalUserUpdateRequest normalUserUpdateRequest);

    /**
     * 删除学生信息
     * @param id 要删除的学生的id
     */
    void deleteNormalUserById(Long id);

    /**
     * 添加新用户
     * @param openId 新用户的openId
     * 新用户首次登录时，保存其openId
     */
    void addNormalUser(String openId);

    /**
     * 新用户注册
     * @param normalUserRegisterRequest 包含新用户注册信息
     * 包含姓名 性别 班级 学号
     */
    void registerNormalUser(Long id, NormalUserRegisterRequest normalUserRegisterRequest);
}
