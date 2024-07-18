package com.cse260.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cse260.lease.model.entity.SystemPost;
import com.cse260.lease.model.entity.SystemUser;
import com.cse260.lease.web.admin.mapper.SystemPostMapper;
import com.cse260.lease.web.admin.mapper.SystemUserMapper;
import com.cse260.lease.web.admin.service.SystemUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.web.admin.vo.system.user.SystemUserItemVo;
import com.cse260.lease.web.admin.vo.system.user.SystemUserQueryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author cse
 * @description 针对表【system_user(员工信息表)】的数据库操作Service实现
 * @createDate 2024-06-24 15:48:00
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
        implements SystemUserService {

    @Autowired
    private SystemUserMapper systemUserMapper;
    @Autowired
    private SystemPostMapper systemPostMapper;
    @Override
    public IPage<SystemUserItemVo> pageSystemUser(Page<SystemUser> page, SystemUserQueryVo queryVo) {
        return systemUserMapper.pageSystemUser(page,queryVo);
    }

    @Override
    public SystemUserItemVo getSystemUserById(Long id) {
        SystemUser systemUser = systemUserMapper.selectById(id);
        SystemPost systemPost =systemPostMapper.selectById(systemUser.getPostId());

        SystemUserItemVo systemUserItemVo = new SystemUserItemVo();
        BeanUtils.copyProperties(systemUser,systemUserItemVo);
        systemUserItemVo.setPostName(systemPost.getName());
        return systemUserItemVo;
    }
}




