package cn.bobolaboratory.springboot.utils;

import cn.bobolaboratory.springboot.security.AuthNormalUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author WhiteLeaf03
 */
public class UserUtil {
    /**
     * 获取用户id
     */
    public static Long getNormalUserId() {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        AuthNormalUser authNormalUser = (AuthNormalUser) authentication.getPrincipal();
        return authNormalUser.getNormalUser().getId();
    }
}
