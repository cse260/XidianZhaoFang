package com.cse260.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.model.entity.AttrValue;
import com.cse260.lease.web.admin.service.AttrValueService;
import com.cse260.lease.web.admin.mapper.AttrValueMapper;
import org.springframework.stereotype.Service;

/**
* @Author cse
* @description 针对表【attr_value(房间基本属性值表)】的数据库操作Service实现
* @createDate 2024-06-24 15:48:00
*/
@Service
public class AttrValueServiceImpl extends ServiceImpl<AttrValueMapper, AttrValue>
    implements AttrValueService{

}




