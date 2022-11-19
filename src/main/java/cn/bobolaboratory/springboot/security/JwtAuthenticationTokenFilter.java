package cn.bobolaboratory.springboot.security;


import cn.bobolaboratory.springboot.utils.JwtUtil;
import cn.bobolaboratory.springboot.utils.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private final RedisCache redisCache;

    @Autowired
    public JwtAuthenticationTokenFilter(RedisCache redisCache) {
        this.redisCache = redisCache;
    }

    /**
     * 拦截所有请求
     * 对请求进行解析
     * 如果header中存有token
     * 就对token进行解析
     * 凭解析token获得的用户id在redis中查找
     * 将redis中存放的loginUser对象封装进UsernamePasswordAuthenticationToken
     * 将UsernamePasswordAuthenticationToken存入SecurityContextHolder
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            //该请求中未含有token 不做处理
            filterChain.doFilter(request, response);
            return;
        }
        //解析token
        String userId;
        try {
            Claims claims = JwtUtil.parseJwt(token);
            userId = claims.getSubject();
        } catch (Exception e) {
            throw new RuntimeException("token非法");
        }
        //从redis中获取用户信息
        AuthBackstageUser authBackstageUser = new AuthBackstageUser(redisCache.getCacheObject("[OnlineUser]id:" + userId));
        if (Objects.isNull(authBackstageUser.getBackstageUser())) {
            throw new  RuntimeException("用户未登录");
        }
        //存入SecurityContextHolder
        //TODO 获取权限信息 封装到Authentication
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authBackstageUser, null, authBackstageUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
