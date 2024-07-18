package com.cse260.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cse260.lease.common.constant.RedisConstant;
import com.cse260.lease.common.exception.LeaseException;
import com.cse260.lease.common.result.ResultCodeEnum;
import com.cse260.lease.common.utils.JwtUtil;
import com.cse260.lease.model.entity.SystemUser;
import com.cse260.lease.model.enums.BaseStatus;
import com.cse260.lease.web.admin.mapper.SystemUserMapper;
import com.cse260.lease.web.admin.service.LoginService;
import com.cse260.lease.web.admin.vo.login.CaptchaVo;
import com.cse260.lease.web.admin.vo.login.LoginVo;
import com.cse260.lease.web.admin.vo.system.user.SystemUserInfoVo;
import com.wf.captcha.SpecCaptcha;
import io.minio.Digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.rmi.dgc.Lease;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private SystemUserMapper systemUserMapper;
    @Override
    public CaptchaVo getCaptcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);

        String code = specCaptcha.text().toLowerCase();
        String key= RedisConstant.ADMIN_LOGIN_PREFIX+UUID.randomUUID();

        stringRedisTemplate.opsForValue().set(key,code,RedisConstant.ADMIN_LOGIN_CAPTCHA_TTL_SEC, TimeUnit.SECONDS);

        return new CaptchaVo(specCaptcha.toBase64(),key);
    }

    @Override
    public String login(LoginVo loginVo) {
        //校验前端传来的验证码是否为空
        if(loginVo.getCaptchaCode()==null){
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_NOT_FOUND);
        }
        //校验redis中验证码是否存在（可能会过期）
        String code=stringRedisTemplate.opsForValue().get(loginVo.getCaptchaKey());
        if(code==null){
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_EXPIRED);
        }

        //校验验证码是否正确
        if(!code.equals(loginVo.getCaptchaCode().toLowerCase())){
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_ERROR);
        }

        //查询数据库中username对应的这条数据
        SystemUser systemUser = systemUserMapper.selectOneByUsername(loginVo.getUsername());

        //校验是否存在这条数据
        if(systemUser==null){
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_NOT_EXIST_ERROR);
        }
        //校验账号是否被禁
        if(systemUser.getStatus()== BaseStatus.DISABLE){
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_DISABLED_ERROR);
        }

        //校验密码是否正确
        if(!systemUser.getPassword().equals(DigestUtils.md5Hex(loginVo.getPassword()))){
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_ERROR);
        }
        return JwtUtil.createToken(systemUser.getId(),systemUser.getUsername());
    }

    @Override
    public SystemUserInfoVo getLoginUserInfoById(Long userId) {
        SystemUser systemUser = systemUserMapper.selectById(userId);
        SystemUserInfoVo systemUserInfoVo = new SystemUserInfoVo();
        systemUserInfoVo.setName(systemUser.getName());
        systemUserInfoVo.setAvatarUrl(systemUser.getAvatarUrl());
        return systemUserInfoVo;
    }
}
