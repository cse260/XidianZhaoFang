package com.cse260.lease.web.admin.mapper;

import com.cse260.lease.model.entity.FacilityInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Author cse
* @description 针对表【facility_info(配套信息表)】的数据库操作Mapper
* @createDate 2024-06-24 15:48:00
* @Entity com.cse260.lease.model.FacilityInfo
*/
public interface FacilityInfoMapper extends BaseMapper<FacilityInfo> {

    List<FacilityInfo> selectListByApartmentId(@Param("id") Long id);

    List<FacilityInfo> selectListByRoomId(Long id);
}




