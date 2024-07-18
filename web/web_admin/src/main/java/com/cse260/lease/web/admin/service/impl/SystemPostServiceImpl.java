package com.cse260.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.model.entity.SystemPost;
import com.cse260.lease.web.admin.service.SystemPostService;
import com.cse260.lease.web.admin.mapper.SystemPostMapper;
import org.springframework.stereotype.Service;

/**
* @Author cse
* @description 针对表【system_post(岗位信息表)】的数据库操作Service实现
* @createDate 2024-06-24 15:48:00
*/
@Service
public class SystemPostServiceImpl extends ServiceImpl<SystemPostMapper, SystemPost>
    implements SystemPostService{

}




