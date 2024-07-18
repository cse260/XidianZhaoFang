package com.cse260.lease.web.app.mapper;

import com.cse260.lease.model.entity.LeaseTerm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @Author cse
* @description 针对表【lease_term(租期)】的数据库操作Mapper
* @createDate 2024-06-26 11:12:39
* @Entity com.cse260.lease.model.entity.LeaseTerm
*/
public interface LeaseTermMapper extends BaseMapper<LeaseTerm> {

    List<LeaseTerm> selectListByRoomId(Long id);
}




