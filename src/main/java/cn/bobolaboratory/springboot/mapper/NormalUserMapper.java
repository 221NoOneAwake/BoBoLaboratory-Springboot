package cn.bobolaboratory.springboot.mapper;

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
     * @param normalUser 要更新的学生信息
     */
    void updateNormalUserById(NormalUser normalUser);

    /**
     * 删除学生信息
     * @param id 要删除的学生的id
     */
    void deleteNormalUserById(Long id);

    /**
     * 新用户注册
     * @param normalUser 包含新用户的openId
     */
    void registerNormalUser(NormalUser normalUser);

    /**
     * 新用户信息完善
     * @param normalUser 包含openId和用户信息
     */
    void addNormalUser(NormalUser normalUser);
}
