package com.cse260.lease.web.app.mapper;

import com.cse260.lease.model.entity.LabelInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @Author cse
* @description 针对表【label_info(标签信息表)】的数据库操作Mapper
* @createDate 2024-06-26 11:12:39
* @Entity com.cse260.lease.model.entity.LabelInfo
*/
public interface LabelInfoMapper extends BaseMapper<LabelInfo> {

    List<LabelInfo> selectListByRoomId(Long id);

    List<LabelInfo> selectListByApartmentId(Long id);
}




