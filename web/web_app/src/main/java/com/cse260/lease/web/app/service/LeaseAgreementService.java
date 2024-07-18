package com.cse260.lease.web.app.service;

import com.cse260.lease.model.entity.LeaseAgreement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cse260.lease.web.app.vo.agreement.AgreementDetailVo;
import com.cse260.lease.web.app.vo.agreement.AgreementItemVo;

import java.util.List;

/**
* @Author cse
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Service
* @createDate 2024-06-26 11:12:39
*/
public interface LeaseAgreementService extends IService<LeaseAgreement> {
    List<AgreementItemVo> listItemByPhone(String phone);

    AgreementDetailVo getDetailById(Long id);
}
