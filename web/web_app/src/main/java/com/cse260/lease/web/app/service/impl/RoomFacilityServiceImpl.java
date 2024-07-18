package com.cse260.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.model.entity.RoomFacility;
import com.cse260.lease.web.app.service.RoomFacilityService;
import com.cse260.lease.web.app.mapper.RoomFacilityMapper;
import org.springframework.stereotype.Service;

/**
* @Author cse
* @description 针对表【room_facility(房间&配套关联表)】的数据库操作Service实现
* @createDate 2024-06-26 11:12:39
*/
@Service
public class RoomFacilityServiceImpl extends ServiceImpl<RoomFacilityMapper, RoomFacility>
    implements RoomFacilityService{

}




