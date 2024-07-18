package com.cse260.lease.web.admin.mapper;

import com.cse260.lease.model.entity.AttrKey;
import com.cse260.lease.web.admin.vo.attr.AttrKeyVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @Author cse
* @description 针对表【attr_key(房间基本属性表)】的数据库操作Mapper
* @createDate 2024-06-24 15:48:00
* @Entity com.cse260.lease.model.AttrKey
*/
public interface AttrKeyMapper extends BaseMapper<AttrKey> {

    List<AttrKeyVo> listAttrInfo();
}




