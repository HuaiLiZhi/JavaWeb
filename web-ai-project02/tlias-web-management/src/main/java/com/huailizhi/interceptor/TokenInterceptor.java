package com.huailizhi.interceptor;

import com.huailizhi.pojo.LogInfo;
import com.huailizhi.utils.BaseContext;
import com.huailizhi.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
//@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求路径
        String path = request.getServletPath(); // /login

        //判断是否是登录请求，如果是则放行
        if ("/login".equals(path)){
            log.info("登录请求：{}", path);
            return true;
        }

        //获取请求头的token
        String token = request.getHeader("token");

        //判断token是否存在，如果不存在，说明用户没有登录，返回401
        if (token == null || token.isEmpty()){
            log.info("用户未登录，请先登录");
            response.setStatus(401);
            return false;
        }

        //如果token存在，校验令牌，如果校验失败返回401
        try {
            Claims claims = JwtUtils.parseJWT(token);
            // 将用户信息存储到ThreadLocal中
            LogInfo logInfo = new LogInfo();
            logInfo.setId((Integer) claims.get("id"));
            logInfo.setUsername((String) claims.get("username"));
            logInfo.setName((String) claims.get("name"));
            BaseContext.setCurrentLogInfo(logInfo);
        } catch (Exception e){
            log.info("令牌校验失败");
            response.setStatus(401);
            return false;
        }

        //校验通过，放行
        log.info("令牌校验通过");
        return true;
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清理ThreadLocal中的用户信息，防止内存泄漏
        BaseContext.removeCurrentLogInfo();
    }
}