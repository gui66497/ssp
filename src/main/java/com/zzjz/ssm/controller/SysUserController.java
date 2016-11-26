package com.zzjz.ssm.controller;

import com.zzjz.ssm.pojo.SysUser;
import com.zzjz.ssm.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户controller
 * @author fgt
 * @version 2016/11/15
 */
@Controller
@RequestMapping("/sysUserController")
public class SysUserController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(SysUserController.class);

    @Resource
    private SysUserService sysUserService;

    @RequestMapping("/test-logback")
    @ResponseBody
    public Date testLogback() {
        LOG.trace("-----------------------------------trace");
        LOG.debug("-----------------------------------debug");
        LOG.info("-----------------------------------info");
        LOG.warn("-----------------------------------warn");
        LOG.error("-----------------------------------error");
        return new Date();
    }

    /**
     * 根据userId获取用户信息 并跳转页面
     * @param model model
     * @param userId userId
     * @return 路径
     */
    @RequestMapping("/showUserToJspById/{userId}")
    public String showUser(Model model, @PathVariable("userId") Long userId) {
        SysUser user = this.sysUserService.getById(userId);
        model.addAttribute("user", user);
        return "showUser";
    }

    /**
     * 根据userId获取用户信息
     * @param userId userId
     * @return 用户信息
     */
    @RequestMapping("/showUserToJSONById/{userId}")
    @ResponseBody
    public SysUser showUser(@PathVariable("userId") Long userId) {
        SysUser user = sysUserService.getById(userId);
        return user;
    }

}
