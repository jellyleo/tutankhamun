/**
 * LEKU APPLIANCE CHAINS.
 * Copyright (c) 2016-2016 All Rights Reserved.
 */
package com.jellyleo.strategy;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * 功能描述: 消息服务上下文
 *
 * @author Jelly
 * @created 2019年11月22日
 * @version 1.0.0
 */
@Component
public class MessageServiceContext {

	  private final Map<Integer, MessageService> handlerMap = new HashMap<>();

	    public MessageService getMessageService(Integer type) {
	        return handlerMap.get(type);
	    }

	    public void putMessageService(Integer code, MessageService messageService) {
	        handlerMap.put(code, messageService);
	    }
}
