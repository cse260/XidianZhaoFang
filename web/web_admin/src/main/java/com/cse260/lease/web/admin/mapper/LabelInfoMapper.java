package com.cse260.lease.web.admin.mapper;

import com.cse260.lease.model.entity.LabelInfo;
import com.cse260.lease.model.enums.ItemType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Author cse
* @description 针对表【label_info(标签信息表)】的数据库操作Mapper
* @createDate 2024-06-24 15:48:00
* @Entity com.cse260.lease.model.LabelInfo
*/
public interface LabelInfoMapper extends BaseMapper<LabelInfo> {


    List<LabelInfo> selectListByApartmentId(@Param("id") Long id);

    List<LabelInfo> selectListByRoomId(Long id);
}




