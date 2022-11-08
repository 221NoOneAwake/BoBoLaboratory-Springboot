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
    List<NormalUser> queryNormalUserByOpenid(String openid);

}
