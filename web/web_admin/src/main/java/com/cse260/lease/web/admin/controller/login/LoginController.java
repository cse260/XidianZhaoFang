package com.cse260.lease.web.admin.controller.login;


import com.cse260.lease.common.login.LoginUserHolder.LoginUserHolder;
import com.cse260.lease.common.result.Result;
import com.cse260.lease.common.utils.JwtUtil;
import com.cse260.lease.web.admin.service.LoginService;
import com.cse260.lease.web.admin.vo.login.CaptchaVo;
import com.cse260.lease.web.admin.vo.login.LoginVo;
import com.cse260.lease.web.admin.vo.system.user.SystemUserInfoVo;
import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;

@Tag(name = "后台管理系统登录管理")
@RestController
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private LoginService service;
    @Operation(summary = "获取图形验证码")
    @GetMapping("login/captcha")
    public Result<CaptchaVo> getCaptcha() {
        CaptchaVo result=service.getCaptcha();
        return Result.ok(result);
    }

    @Operation(summary = "登录")
    @PostMapping("login")
    public Result<String> login(@RequestBody LoginVo loginVo) {
        String jwt=service.login(loginVo);
        return Result.ok(jwt);
    }

    @Operation(summary = "获取登陆用户个人信息")
    @GetMapping("info")
    public Result<SystemUserInfoVo> info(@RequestHeader("access-token") String token) {
        Long userId = LoginUserHolder.getLoginUser().getUserId();
        SystemUserInfoVo systemUserInfoVo=service.getLoginUserInfoById(userId);
        return Result.ok(systemUserInfoVo);
    }
}