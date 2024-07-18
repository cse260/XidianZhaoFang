package com.cse260.lease.web.app.mapper;

import com.cse260.lease.model.entity.LeaseAgreement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cse260.lease.web.app.vo.agreement.AgreementItemVo;

import java.util.List;

/**
* @Author cse
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Mapper
* @createDate 2024-06-26 11:12:39
* @Entity com.cse260.lease.model.entity.LeaseAgreement
*/
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    List<AgreementItemVo> listItemByPhone(String phone);
}




