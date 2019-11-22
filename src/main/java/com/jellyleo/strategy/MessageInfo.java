/**
 * LEKU APPLIANCE CHAINS.
 * Copyright (c) 2016-2016 All Rights Reserved.
 */
package com.jellyleo.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 功能描述:
 *
 * @author Jelly
 * @created 2019年11月21日
 * @version 1.0.0
 */
@Data
@AllArgsConstructor
public class MessageInfo {

	// 消息类型
	private Integer type;
	// 消息内容
	private String content;
}
