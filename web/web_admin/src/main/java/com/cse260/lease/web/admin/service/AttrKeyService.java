package com.cse260.lease.web.admin.service;

import com.cse260.lease.model.entity.AttrKey;
import com.cse260.lease.web.admin.vo.attr.AttrKeyVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @Author cse
* @description 针对表【attr_key(房间基本属性表)】的数据库操作Service
* @createDate 2024-06-24 15:48:00
*/
public interface AttrKeyService extends IService<AttrKey> {

    List<AttrKeyVo> listAttrInfo();
}
