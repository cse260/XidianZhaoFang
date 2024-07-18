package com.cse260.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.model.entity.FeeValue;
import com.cse260.lease.web.admin.service.FeeValueService;
import com.cse260.lease.web.admin.mapper.FeeValueMapper;
import org.springframework.stereotype.Service;

/**
* @Author cse
* @description 针对表【fee_value(杂项费用值表)】的数据库操作Service实现
* @createDate 2024-06-24 15:48:00
*/
@Service
public class FeeValueServiceImpl extends ServiceImpl<FeeValueMapper, FeeValue>
    implements FeeValueService{

}




