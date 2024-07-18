package com.cse260.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cse260.lease.model.entity.GraphInfo;
import com.cse260.lease.web.app.service.GraphInfoService;
import com.cse260.lease.web.app.mapper.GraphInfoMapper;
import org.springframework.stereotype.Service;

/**
* @Author cse
* @description 针对表【graph_info(图片信息表)】的数据库操作Service实现
* @createDate 2024-06-26 11:12:39
*/
@Service
public class GraphInfoServiceImpl extends ServiceImpl<GraphInfoMapper, GraphInfo>
    implements GraphInfoService{

}




