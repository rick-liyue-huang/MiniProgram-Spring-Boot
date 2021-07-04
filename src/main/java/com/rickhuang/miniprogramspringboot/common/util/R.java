package com.rickhuang.miniprogramspringboot.common.util;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String, Object> {
	/**
	 * 构造函数用来返回初始值
	 */
	public R() {
		put("code", HttpStatus.SC_OK);
		put("msg", "success");
	}

	/**
	 * 生成新的put方法得到链式结构
	 * @param key
	 * @param value
	 * @return
	 */
	@Override
	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}

	/**
	 * 静态工厂方法
	 * @return
	 */
	public static R ok() {
		return new R();
	}

	/**
	 * 静态重载的工厂方法
	 * @param msg
	 * @return
	 */
	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}

	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}

	/**
	 * 创建工厂方法处理错误情况
	 * @param code
	 * @param msg
	 * @return
	 */
	public static R error(int code, String msg) {
		R r = new R();
		r.put("msg", msg);
		r.put("code", code);
		return r;
	}

	/**
	 * 重载错误方法
	 * @param msg
	 * @return
	 */
	public static R error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}

	public static R error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "unknown exception, tell manager");
	}

}
