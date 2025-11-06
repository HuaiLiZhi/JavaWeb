package com.huailizhi.filter;

import com.huailizhi.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取请求路径
        String path = request.getServletPath(); // /login

        //判断是否是登录请求，如果是则放行
        if ("/login".equals(path)){
            log.info("登录请求：{}", path);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        //获取请求头的token
        String token = request.getHeader("token");

        //判断token是否存在，如果不存在，说明用户没有登录，返回401
        if (token == null || token.isEmpty()){
            log.info("用户未登录，请先登录");
            response.setStatus(401);
            return;
        }

        //如果token存在，校验令牌，如果校验失败返回401
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e){
            log.info("令牌校验失败");
            response.setStatus(401);
            return;
        }

        //校验通过，放行
        log.info("令牌校验通过");
        filterChain.doFilter(servletRequest, servletResponse);

    }
}
