package com.cse260.lease.web.admin.mapper;

import com.cse260.lease.model.entity.RoomInfo;
import com.cse260.lease.web.admin.vo.room.RoomItemVo;
import com.cse260.lease.web.admin.vo.room.RoomQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

/**
* @Author cse
* @description 针对表【room_info(房间信息表)】的数据库操作Mapper
* @createDate 2024-06-24 15:48:00
* @Entity com.cse260.lease.model.RoomInfo
*/
public interface RoomInfoMapper extends BaseMapper<RoomInfo> {

    IPage<RoomItemVo> pageRoomItemByQuery(@Param("page") IPage<RoomItemVo> page, @Param("queryVo") RoomQueryVo queryVo);
}




