package com.cse260.lease.web.admin.schedule;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cse260.lease.model.entity.LeaseAgreement;
import com.cse260.lease.model.enums.LeaseStatus;
import com.cse260.lease.web.admin.service.LeaseAgreementService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduleTasks {
//    @Scheduled(cron="* * * * * *")
//    public void test(){
//        System.out.println(new Date());
//    }

    @Autowired
    private LeaseAgreementService service;

    @Scheduled(cron="0 0 0 * * *")
    public void checkLeaseStatus(){
        LambdaUpdateWrapper<LeaseAgreement> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.le(LeaseAgreement::getLeaseEndDate,new Date());
        updateWrapper.in(LeaseAgreement::getStatus,LeaseStatus.WITHDRAWING,LeaseStatus.SIGNED);
        updateWrapper.set(LeaseAgreement::getStatus, LeaseStatus.EXPIRED);
        service.update(updateWrapper);
    }

}
