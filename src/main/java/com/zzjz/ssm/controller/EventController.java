package com.zzjz.ssm.controller;

import com.zzjz.ssm.model.DataGridModel;
import com.zzjz.ssm.model.page.Pagination;
import com.zzjz.ssm.service.EventService;
import com.zzjz.ssm.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 事件 Controller
 * @Author fgt
 * @Date 2016/4/26 9:19
 */
@Controller
@RequestMapping("/event")
public class EventController extends BaseController {

    Logger logger = LoggerFactory.getLogger(EventController.class);

    @Resource
    private SysUserService sysUserService;

    @Autowired
    private EventService eventService;

    /**
     * 跳转到事件详情页面
     * @Author fgt
     * @Date 2016/4/28 17:19
     */
    @RequestMapping("/toList")
    public String  listEventDetail() {
        return "/event/listEventDetail";
    }

    /**
     * 事件详情页面
     * @Author fgt
     * @Date 2016/4/28 17:15
     */
    @RequestMapping("/list")
    @ResponseBody
    public Pagination listEventDetail(DataGridModel model) {
        logger.debug("调用/event/list");
        int pageNo = model.getPage();
        int pageSize = model.getRows();
        return eventService.listEventDetail(pageNo, pageSize);
    }

    /**
     * 容器初始化完成之后调用
     * @author fgt
     */
    @PostConstruct
    public void init() {
        System.out.println("初始化的时候！！！！！");
    }

}
