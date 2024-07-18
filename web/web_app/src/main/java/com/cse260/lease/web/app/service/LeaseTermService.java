package com.cse260.lease.web.app.service;

import com.cse260.lease.model.entity.LeaseTerm;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @Author cse
* @description 针对表【lease_term(租期)】的数据库操作Service
* @createDate 2024-06-26 11:12:39
*/
public interface LeaseTermService extends IService<LeaseTerm> {
    List<LeaseTerm> listByRoomId(Long id);
}
