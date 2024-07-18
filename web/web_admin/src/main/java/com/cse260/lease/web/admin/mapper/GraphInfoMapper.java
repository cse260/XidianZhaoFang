package com.cse260.lease.web.admin.mapper;

import com.cse260.lease.model.entity.GraphInfo;
import com.cse260.lease.model.enums.ItemType;
import com.cse260.lease.web.admin.vo.graph.GraphVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Author cse
* @description 针对表【graph_info(图片信息表)】的数据库操作Mapper
* @createDate 2024-06-24 15:48:00
* @Entity com.cse260.lease.model.GraphInfo
*/
public interface GraphInfoMapper extends BaseMapper<GraphInfo> {

    List<GraphVo> selectListByItemTypeAndId(@Param("itemType") ItemType itemType, @Param("id") Long id);

}




