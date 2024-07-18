package com.cse260.lease.web.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cse260.lease.model.entity.BrowsingHistory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cse260.lease.web.app.vo.history.HistoryItemVo;

/**
* @Author cse
* @description 针对表【browsing_history(浏览历史)】的数据库操作Service
* @createDate 2024-06-26 11:12:39
*/
public interface BrowsingHistoryService extends IService<BrowsingHistory> {
    IPage<HistoryItemVo> pageItemByUserId(Page<HistoryItemVo> page, Long userId);

    void saveHistory(Long userId, Long id);
}
