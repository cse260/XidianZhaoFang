package com.cse260.lease.web.admin.custom.interceptor;

import com.cse260.lease.common.exception.LeaseException;
import com.cse260.lease.common.login.LoginUserHolder.LoginUser;
import com.cse260.lease.common.login.LoginUserHolder.LoginUserHolder;
import com.cse260.lease.common.result.ResultCodeEnum;
import com.cse260.lease.common.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

//拦截器
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    //在调用方法之前进行拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //根据前端约定，在请求头里获取token
        String token = request.getHeader("access-token");

        Claims claims = JwtUtil.parseToken(token);
        Long userId = claims.get("userId", Long.class);
        String username = claims.get("username", String.class);
        LoginUserHolder.setLoginUser(new LoginUser(userId,username));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LoginUserHolder.clear();
    }
}
