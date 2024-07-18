package com.cse260.lease.web.admin.mapper;

import com.cse260.lease.model.entity.AttrValue;
import com.cse260.lease.web.admin.vo.attr.AttrValueVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @Author cse
* @description 针对表【attr_value(房间基本属性值表)】的数据库操作Mapper
* @createDate 2024-06-24 15:48:00
* @Entity com.cse260.lease.model.AttrValue
*/
public interface AttrValueMapper extends BaseMapper<AttrValue> {

    List<AttrValueVo> selectListByRoomId(Long id);
}




