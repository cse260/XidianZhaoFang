package com.cse260.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.model.entity.ApartmentLabel;
import com.cse260.lease.web.app.service.ApartmentLabelService;
import com.cse260.lease.web.app.mapper.ApartmentLabelMapper;
import org.springframework.stereotype.Service;

/**
* @Author cse
* @description 针对表【apartment_label(公寓标签关联表)】的数据库操作Service实现
* @createDate 2024-06-26 11:12:39
*/
@Service
public class ApartmentLabelServiceImpl extends ServiceImpl<ApartmentLabelMapper, ApartmentLabel>
    implements ApartmentLabelService{
}
