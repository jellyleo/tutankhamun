/**
 * LEKU APPLIANCE CHAINS.
 * Copyright (c) 2016-2016 All Rights Reserved.
 */
package com.jellyleo.strategy;

import java.util.Map;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 功能描述:pring的启动过程中，通过解析注解，将消息类型->消息处理对象的映射关系保存到MessageServiceContext对象中
 *
 * @author Jelly
 * @created 2019年11月22日
 * @version 1.0.0
 */
@Component
public class MessageServiceListener implements ApplicationListener<ContextRefreshedEvent> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.
	 * springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Map<String, Object> beans = event.getApplicationContext().getBeansWithAnnotation(MsgTypeHandler.class);
		MessageServiceContext messageServiceContext = event.getApplicationContext()
				.getBean(MessageServiceContext.class);
		beans.forEach((name, bean) -> {
			MsgTypeHandler typeHandler = bean.getClass().getAnnotation(MsgTypeHandler.class);
			messageServiceContext.putMessageService(typeHandler.value().code, (MessageService) bean);
		});
	}

}
