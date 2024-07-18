package com.cse260.lease.web.admin.mapper;

import com.cse260.lease.model.entity.ApartmentInfo;
import com.cse260.lease.model.enums.LeaseStatus;
import com.cse260.lease.web.admin.vo.apartment.ApartmentItemVo;
import com.cse260.lease.web.admin.vo.apartment.ApartmentQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
* @Author cse
* @description 针对表【apartment_info(公寓信息表)】的数据库操作Mapper
* @createDate 2024-06-24 15:48:00
* @Entity com.cse260.lease.model.ApartmentInfo
*/
public interface ApartmentInfoMapper extends BaseMapper<ApartmentInfo> {

    IPage<ApartmentItemVo> pageItem(@Param("page") Page<ApartmentItemVo> page, @Param("queryVo") ApartmentQueryVo queryVo);
}




