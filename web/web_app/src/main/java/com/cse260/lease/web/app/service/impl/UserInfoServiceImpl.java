package com.cse260.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.model.entity.UserInfo;
import com.cse260.lease.web.app.service.UserInfoService;
import com.cse260.lease.web.app.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @Author cse
* @description 针对表【user_info(用户信息表)】的数据库操作Service实现
* @createDate 2024-06-26 11:12:39
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




