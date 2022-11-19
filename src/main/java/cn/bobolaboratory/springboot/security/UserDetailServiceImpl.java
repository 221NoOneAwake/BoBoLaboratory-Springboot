package cn.bobolaboratory.springboot.security;

import cn.bobolaboratory.springboot.entity.BackstageUser;
import cn.bobolaboratory.springboot.mapper.BackstageUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author WhiteLeaf03
 * 用户登录验证过滤器
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final BackstageUserMapper backstageUserMapper;

    @Autowired
    public UserDetailServiceImpl(BackstageUserMapper backstageUserMapper) {
        this.backstageUserMapper = backstageUserMapper;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询用户信息
        BackstageUser user = backstageUserMapper.queryBackstageUserByUsername(username);
        //TODO 返回权限信息
        if (Objects.isNull(user)) {
            //未查询到该用户
            throw new RuntimeException("用户名不存在");
        } else {
            //查询到用户
            return new AuthBackstageUser(user);
        }
    }
}
