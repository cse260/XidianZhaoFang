package com.cse260.lease.web.app.mapper;

import com.cse260.lease.model.entity.GraphInfo;
import com.cse260.lease.model.enums.ItemType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cse260.lease.web.app.vo.graph.GraphVo;

import java.util.List;

/**
* @Author cse
* @description 针对表【graph_info(图片信息表)】的数据库操作Mapper
* @createDate 2024-06-26 11:12:39
* @Entity com.cse260.lease.model.entity.GraphInfo
*/
public interface GraphInfoMapper extends BaseMapper<GraphInfo> {

    List<GraphVo> selectListByItemTypeAndId(ItemType itemType, Long id);
}




