package com.cse260.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cse260.lease.model.entity.BrowsingHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cse260.lease.web.app.vo.history.HistoryItemVo;

/**
* @Author cse
* @description 针对表【browsing_history(浏览历史)】的数据库操作Mapper
* @createDate 2024-06-26 11:12:39
* @Entity com.cse260.lease.model.entity.BrowsingHistory
*/
public interface BrowsingHistoryMapper extends BaseMapper<BrowsingHistory> {

    IPage<HistoryItemVo> pageItemByUserId(Page<HistoryItemVo> page, Long userId);
}




