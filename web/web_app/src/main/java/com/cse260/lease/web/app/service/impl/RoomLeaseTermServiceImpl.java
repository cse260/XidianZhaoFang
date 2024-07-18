package com.cse260.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.model.entity.RoomLeaseTerm;
import com.cse260.lease.web.app.service.RoomLeaseTermService;
import com.cse260.lease.web.app.mapper.RoomLeaseTermMapper;
import org.springframework.stereotype.Service;

/**
* @Author cse
* @description 针对表【room_lease_term(房间租期管理表)】的数据库操作Service实现
* @createDate 2024-06-26 11:12:39
*/
@Service
public class RoomLeaseTermServiceImpl extends ServiceImpl<RoomLeaseTermMapper, RoomLeaseTerm>
    implements RoomLeaseTermService{

}




