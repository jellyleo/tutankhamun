/**
 * LEKU APPLIANCE CHAINS.
 * Copyright (c) 2016-2016 All Rights Reserved.
 */
package com.jellyleo.strategy;

/**
 * 功能描述:
 *
 * @author Jelly
 * @created 2019年11月22日
 * @version 1.0.0
 */
public enum MSG_TYPE {

	TEXT(1, "文本"), IMAGE(2, "图片"), VIDEO(3, "视频");

	public final int code;
	public final String name;

	MSG_TYPE(int code, String name) {
		this.code = code;
		this.name = name;
	}
}
