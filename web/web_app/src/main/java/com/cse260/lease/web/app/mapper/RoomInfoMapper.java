package com.cse260.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cse260.lease.model.entity.RoomInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cse260.lease.web.app.vo.room.RoomItemVo;
import com.cse260.lease.web.app.vo.room.RoomQueryVo;

import java.math.BigDecimal;

/**
* @Author cse
* @description 针对表【room_info(房间信息表)】的数据库操作Mapper
* @createDate 2024-06-26 11:12:39
* @Entity com.cse260.lease.model.entity.RoomInfo
*/
public interface RoomInfoMapper extends BaseMapper<RoomInfo> {

    IPage<RoomItemVo> pageItem(Page<RoomItemVo> page, RoomQueryVo queryVo);

    BigDecimal selectMinRentByApartmentId(Long id);

    IPage<RoomItemVo> pageItemByApartmentId(Page<RoomItemVo> page, Long id);
}