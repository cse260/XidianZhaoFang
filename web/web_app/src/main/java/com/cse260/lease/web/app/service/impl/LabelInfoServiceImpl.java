package com.cse260.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.model.entity.LabelInfo;
import com.cse260.lease.web.app.service.LabelInfoService;
import com.cse260.lease.web.app.mapper.LabelInfoMapper;
import org.springframework.stereotype.Service;

/**
* @Author cse
* @description 针对表【label_info(标签信息表)】的数据库操作Service实现
* @createDate 2024-06-26 11:12:39
*/
@Service
public class LabelInfoServiceImpl extends ServiceImpl<LabelInfoMapper, LabelInfo>
    implements LabelInfoService{

}




