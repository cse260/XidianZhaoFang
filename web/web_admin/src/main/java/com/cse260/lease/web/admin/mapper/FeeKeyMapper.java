package com.cse260.lease.web.admin.mapper;

import com.cse260.lease.model.entity.FeeKey;
import com.cse260.lease.web.admin.vo.fee.FeeKeyVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @Author cse
* @description 针对表【fee_key(杂项费用名称表)】的数据库操作Mapper
* @createDate 2024-06-24 15:48:00
* @Entity com.cse260.lease.model.FeeKey
*/
public interface FeeKeyMapper extends BaseMapper<FeeKey> {

    List<FeeKeyVo> feeInfoList();
}




