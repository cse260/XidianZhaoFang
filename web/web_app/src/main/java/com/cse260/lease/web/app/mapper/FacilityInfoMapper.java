package com.cse260.lease.web.app.mapper;

import com.cse260.lease.model.entity.FacilityInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @Author cse
* @description 针对表【facility_info(配套信息表)】的数据库操作Mapper
* @createDate 2024-06-26 11:12:39
* @Entity com.cse260.lease.model.entity.FacilityInfo
*/
public interface FacilityInfoMapper extends BaseMapper<FacilityInfo> {

    List<FacilityInfo> selectListByRoomId(Long id);

    List<FacilityInfo> selectListByApartmentId(Long id);
}




