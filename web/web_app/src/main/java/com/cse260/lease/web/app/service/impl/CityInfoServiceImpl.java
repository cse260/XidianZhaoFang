package com.cse260.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.model.entity.CityInfo;
import com.cse260.lease.web.app.service.CityInfoService;
import com.cse260.lease.web.app.mapper.CityInfoMapper;
import org.springframework.stereotype.Service;

/**
* @Author cse
* @description 针对表【city_info】的数据库操作Service实现
* @createDate 2024-06-26 11:12:39
*/
@Service
public class CityInfoServiceImpl extends ServiceImpl<CityInfoMapper, CityInfo>
    implements CityInfoService{

}




