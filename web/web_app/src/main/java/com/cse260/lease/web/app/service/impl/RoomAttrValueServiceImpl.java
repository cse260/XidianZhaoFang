package com.cse260.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.model.entity.RoomAttrValue;
import com.cse260.lease.web.app.service.RoomAttrValueService;
import com.cse260.lease.web.app.mapper.RoomAttrValueMapper;
import org.springframework.stereotype.Service;

/**
* @Author cse
* @description 针对表【room_attr_value(房间&基本属性值关联表)】的数据库操作Service实现
* @createDate 2024-06-26 11:12:39
*/
@Service
public class RoomAttrValueServiceImpl extends ServiceImpl<RoomAttrValueMapper, RoomAttrValue>
    implements RoomAttrValueService{

}




