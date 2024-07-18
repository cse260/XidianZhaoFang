package com.cse260.lease.web.admin.mapper;

import com.cse260.lease.model.entity.FeeValue;
import com.cse260.lease.web.admin.vo.fee.FeeValueVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @Author cse
* @description 针对表【fee_value(杂项费用值表)】的数据库操作Mapper
* @createDate 2024-06-24 15:48:00
* @Entity com.cse260.lease.model.FeeValue
*/
public interface FeeValueMapper extends BaseMapper<FeeValue> {

    List<FeeValueVo> selectListByApartmentId(@Param("id") Long id);
}




