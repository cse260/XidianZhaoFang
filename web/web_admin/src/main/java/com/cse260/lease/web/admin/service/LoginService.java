package com.cse260.lease.web.admin.service;

import com.cse260.lease.web.admin.vo.login.CaptchaVo;
import com.cse260.lease.web.admin.vo.login.LoginVo;
import com.cse260.lease.web.admin.vo.system.user.SystemUserInfoVo;

public interface LoginService {

    CaptchaVo getCaptcha();

    String login(LoginVo loginVo);

    SystemUserInfoVo getLoginUserInfoById(Long userId);
}
