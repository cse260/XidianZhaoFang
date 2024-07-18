package com.cse260.lease.web.app.mapper;

import com.cse260.lease.model.entity.AttrValue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cse260.lease.web.app.vo.attr.AttrValueVo;

import java.util.List;

/**
* @Author cse
* @description 针对表【attr_value(房间基本属性值表)】的数据库操作Mapper
* @createDate 2024-06-26 11:12:39
* @Entity com.cse260.lease.model.entity.AttrValue
*/
public interface AttrValueMapper extends BaseMapper<AttrValue> {

    List<AttrValueVo> selectListByRoomId(Long id);

}




