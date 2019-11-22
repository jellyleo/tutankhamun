/**
 * LEKU APPLIANCE CHAINS.
 * Copyright (c) 2016-2016 All Rights Reserved.
 */
package com.jellyleo.strategy;

import org.springframework.stereotype.Service;

/**
 * 功能描述:
 *
 * @author Jelly
 * @created 2019年11月22日
 * @version 1.0.0
 */
@Service
@MsgTypeHandler(value = MSG_TYPE.TEXT)
public class TextMessageService implements MessageService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jellyleo.designpattern.strategy.MessageService#handleMessage(com.jellyleo
	 * .designpattern.strategy.MessageInfo)
	 */
	@Override
	public void handleMessage(MessageInfo messageInfo) {
		System.out.println("处理文本消息 " + messageInfo.getContent());
	}

}
