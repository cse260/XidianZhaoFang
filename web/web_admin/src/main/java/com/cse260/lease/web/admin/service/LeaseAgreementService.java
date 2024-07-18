package com.cse260.lease.web.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cse260.lease.model.entity.LeaseAgreement;
import com.cse260.lease.web.admin.vo.agreement.AgreementQueryVo;
import com.cse260.lease.web.admin.vo.agreement.AgreementVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @Author cse
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Service
* @createDate 2024-06-24 15:48:00
*/
public interface LeaseAgreementService extends IService<LeaseAgreement> {

    IPage<AgreementVo> pageAgreement(Page<AgreementVo> page, AgreementQueryVo queryVo);

    AgreementVo getAgreementById(Long id);
}
