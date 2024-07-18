package com.cse260.lease.web.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cse260.lease.model.entity.ViewAppointment;
import com.cse260.lease.web.admin.vo.appointment.AppointmentQueryVo;
import com.cse260.lease.web.admin.vo.appointment.AppointmentVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @Author cse
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service
* @createDate 2024-06-24 15:48:00
*/
public interface ViewAppointmentService extends IService<ViewAppointment> {

    IPage<AppointmentVo> pageAppointment(Page<AppointmentVo> page, AppointmentQueryVo queryVo);
}
