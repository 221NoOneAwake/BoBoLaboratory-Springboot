package cn.bobolaboratory.springboot.mapper;

import cn.bobolaboratory.springboot.entity.BackstageUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author WhiteLeaf03
 */
@Mapper
public interface BackstageUserMapper {
    /**
     * 根据username查询用户
     * @param username 要查询用户的username
     * @return 返回查询结果
     */
    BackstageUser queryBackstageUserByUsername(String username);
}
