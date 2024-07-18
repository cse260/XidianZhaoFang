package com.cse260.lease.web.admin.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cse260.lease.model.entity.SystemUser;
import com.cse260.lease.web.admin.vo.system.user.SystemUserItemVo;
import com.cse260.lease.web.admin.vo.system.user.SystemUserQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
* @Author cse
* @description 针对表【system_user(员工信息表)】的数据库操作Mapper
* @createDate 2024-06-24 15:48:00
* @Entity com.cse260.lease.model.SystemUser
*/
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    IPage<SystemUserItemVo> pageSystemUser(Page<SystemUser> page, SystemUserQueryVo queryVo);

    SystemUser selectOneByUsername(String username);
}




