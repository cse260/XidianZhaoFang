package com.cse260.lease.web.app.mapper;

import com.cse260.lease.model.entity.ViewAppointment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cse260.lease.web.app.vo.appointment.AppointmentItemVo;

import java.util.List;

/**
* @Author cse
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Mapper
* @createDate 2024-06-26 11:12:39
* @Entity com.cse260.lease.model.entity.ViewAppointment
*/
public interface ViewAppointmentMapper extends BaseMapper<ViewAppointment> {

    List<AppointmentItemVo> listItemByUserId(Long userId);
}




