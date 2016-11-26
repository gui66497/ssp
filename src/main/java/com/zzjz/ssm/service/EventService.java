package com.zzjz.ssm.service;

import com.zzjz.ssm.model.page.Pagination;

/**
 * 事件service
 * @Author fgt
 * @Date 2016/4/25 18:01
 */
public interface EventService {

    /**
     * 分页获取事件列表
     * @Author fgt
     * @Date 2016/4/28 16:59
     */
    Pagination listEventDetail(int pageNo, int pageSize);

}
