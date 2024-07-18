package com.cse260.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.model.entity.UserInfo;
import com.cse260.lease.web.admin.service.UserInfoService;
import com.cse260.lease.web.admin.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @Author cse
* @description 针对表【user_info(用户信息表)】的数据库操作Service实现
* @createDate 2024-06-24 15:48:00
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




