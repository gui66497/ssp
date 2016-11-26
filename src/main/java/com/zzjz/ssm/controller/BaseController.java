package com.zzjz.ssm.controller;

import com.zzjz.ssm.Constants;
import com.zzjz.ssm.support.HttpCode;
import com.zzjz.ssm.support.exception.BusinessException;
import com.zzjz.ssm.util.WebUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author fgt
 * date 2016/4/27.
 */
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /** 获取当前用户Id */
    protected String getCurrUserId(HttpServletRequest request) {
        return WebUtil.getCurrentUser(request);
    }

    /** 设置成功响应代码 */
    protected ModelMap setSuccessModelMap(ModelMap modelMap) {
        return setSuccessModelMap(modelMap, null);
    }

    /** 设置成功响应代码 */
    protected ModelMap setSuccessModelMap(ModelMap modelMap, Object data) {
        return setModelMap(modelMap, HttpCode.OK, data);
    }

    /** 设置相应代码 */
    protected ModelMap setModelMap(ModelMap modelMap, HttpCode code) {
        return setModelMap(modelMap, code, null);
    }

    /** 设置相应代码 */
    protected ModelMap setModelMap(ModelMap modelMap, HttpCode code, Object data) {
        if (data != null) {
            modelMap.put("data", data);
        }
        modelMap.put("httpCode", code.value());
        modelMap.put("msg", code.msg());
        return modelMap;
    }

    /** 异常处理 */
    @ExceptionHandler(RuntimeException.class)
    public void exceptionHandler(HttpServletResponse response, Exception ex) throws Exception {
        logger.error(Constants.Exception_Head, ex);
        ModelMap modelMap = new ModelMap();
        if (ex instanceof IllegalArgumentException) {
            if (StringUtils.isNotBlank(ex.getMessage())) {
                modelMap.put("httpCode", HttpCode.BAD_REQUEST.value());
                modelMap.put("msg", ex.getMessage());
            } else {
                setModelMap(modelMap, HttpCode.BAD_REQUEST);
            }
        } else if (ex instanceof BusinessException) {
            if (StringUtils.isNotBlank(ex.getMessage())) {
                modelMap.put("httpCode", HttpCode.CONFLICT.value());
                modelMap.put("msg", ex.getMessage());
            } else {
                setModelMap(modelMap, HttpCode.CONFLICT);
            }
        } else {
            setModelMap(modelMap, HttpCode.INTERNAL_SERVER_ERROR);
        }
        response.setContentType("application/json;charset=UTF-8");
        byte[] bytes = JSON.toJSONBytes(modelMap, SerializerFeature.DisableCircularReferenceDetect);
        response.getOutputStream().write(bytes);
    }
}
