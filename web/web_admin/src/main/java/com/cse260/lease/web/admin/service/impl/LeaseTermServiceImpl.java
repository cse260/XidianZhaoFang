package com.cse260.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.model.entity.LeaseTerm;
import com.cse260.lease.web.admin.service.LeaseTermService;
import com.cse260.lease.web.admin.mapper.LeaseTermMapper;
import org.springframework.stereotype.Service;

/**
* @Author cse
* @description 针对表【lease_term(租期)】的数据库操作Service实现
* @createDate 2024-06-24 15:48:00
*/
@Service
public class LeaseTermServiceImpl extends ServiceImpl<LeaseTermMapper, LeaseTerm>
    implements LeaseTermService{

}




