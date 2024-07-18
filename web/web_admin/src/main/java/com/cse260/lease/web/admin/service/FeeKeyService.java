package com.cse260.lease.web.admin.service;

import com.cse260.lease.model.entity.FeeKey;
import com.cse260.lease.web.admin.vo.fee.FeeKeyVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @Author cse
* @description 针对表【fee_key(杂项费用名称表)】的数据库操作Service
* @createDate 2024-06-24 15:48:00
*/
public interface FeeKeyService extends IService<FeeKey> {

    List<FeeKeyVo> feeInfoList();
}
