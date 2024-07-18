package com.cse260.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.model.entity.ApartmentFacility;
import com.cse260.lease.web.app.service.ApartmentFacilityService;
import com.cse260.lease.web.app.mapper.ApartmentFacilityMapper;
import org.springframework.stereotype.Service;

/**
* @Author cse
* @description 针对表【apartment_facility(公寓&配套关联表)】的数据库操作Service实现
* @createDate 2024-06-26 11:12:39
*/
@Service
public class ApartmentFacilityServiceImpl extends ServiceImpl<ApartmentFacilityMapper, ApartmentFacility>
    implements ApartmentFacilityService{
}




