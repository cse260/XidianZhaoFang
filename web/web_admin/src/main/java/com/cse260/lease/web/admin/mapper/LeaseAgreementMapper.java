package com.cse260.lease.web.admin.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cse260.lease.model.entity.LeaseAgreement;
import com.cse260.lease.web.admin.vo.agreement.AgreementQueryVo;
import com.cse260.lease.web.admin.vo.agreement.AgreementVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
* @Author cse
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Mapper
* @createDate 2024-06-24 15:48:00
* @Entity com.cse260.lease.model.LeaseAgreement
*/
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    IPage<AgreementVo> pageAgreement(Page<AgreementVo> page, AgreementQueryVo queryVo);
}




