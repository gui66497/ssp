package com.zzjz.ssm.support;


import com.zzjz.ssm.config.Resource;

/**
 * Ajax 请求时的自定义查询状态码，主要参考Http状态码，但并不完全对应
 * @Author fgt
 * @Date 2016/4/27 17:42
 */
public enum HttpCode {
	/** 200请求成功 */
	OK(200),
	/** 400请求参数出错 */
	BAD_REQUEST(400),
	/** 401没有登录 */
	UNAUTHORIZED(401),
	/** 403没有权限 */
	FORBIDDEN(403),
	/** 404找不到页面 */
	NOT_FOUND(404),
	/** 408请求超时 */
	REQUEST_TIMEOUT(408),
	/** 409发生冲突 */
	CONFLICT(409),
	/** 410已被删除 */
	GONE(410),
	/** 423已被锁定 */
	LOCKED(423),
	/** 500服务器出错 */
	INTERNAL_SERVER_ERROR(500);

	private final Integer value;

	private HttpCode(Integer value) {
		this.value = value;
	}

	/**
	 * Return the integer value of this status code.
	 */
	public Integer value() {
		return this.value;
	}

	public String msg() {
		return Resource.RESOURCE.getString("HTTPCODE_" + this.value);
	}

	public String toString() {
		return this.value.toString();
	}
}
