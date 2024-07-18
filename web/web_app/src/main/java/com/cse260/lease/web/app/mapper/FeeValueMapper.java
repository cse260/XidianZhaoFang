package com.cse260.lease.web.app.mapper;

import com.cse260.lease.model.entity.FeeValue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cse260.lease.web.app.vo.fee.FeeValueVo;

import java.util.List;

/**
* @Author cse
* @description 针对表【fee_value(杂项费用值表)】的数据库操作Mapper
* @createDate 2024-06-26 11:12:39
* @Entity com.cse260.lease.model.entity.FeeValue
*/
public interface FeeValueMapper extends BaseMapper<FeeValue> {

    List<FeeValueVo> selectListByApartmentId(Long apartmentId);
}




