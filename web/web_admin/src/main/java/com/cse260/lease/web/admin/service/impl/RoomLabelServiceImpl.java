package com.cse260.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.model.entity.RoomLabel;
import com.cse260.lease.web.admin.service.RoomLabelService;
import com.cse260.lease.web.admin.mapper.RoomLabelMapper;
import org.springframework.stereotype.Service;

/**
* @Author cse
* @description 针对表【room_label(房间&标签关联表)】的数据库操作Service实现
* @createDate 2024-06-24 15:48:00
*/
@Service
public class RoomLabelServiceImpl extends ServiceImpl<RoomLabelMapper, RoomLabel>
    implements RoomLabelService{

}




