package com.zzjz.ssm.config;

import org.springframework.context.annotation.PropertySource;
import java.util.ResourceBundle;

/** 加载配置 */
@PropertySource(value = {"claspath:/local/resource*.properties" , "claspath:/ssm*.properties"})
public interface Resource {
	/** 国际化信息 */
	ResourceBundle RESOURCE = ResourceBundle.getBundle("local/resource");
	/** 拦截器白名单 */
	/*ResourceBundle WHITEURL = ResourceBundle.getBundle("config/whiteURL");*/
}
