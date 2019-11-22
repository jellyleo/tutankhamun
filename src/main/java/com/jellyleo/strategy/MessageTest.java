package com.jellyleo.strategy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jellyleo.base.JlBaseTest;

/**
 * 
 * 功能描述:
 *
 * @author Jelly
 * @created 2019年11月22日
 * @version 1.0.0
 */
public class MessageTest extends JlBaseTest{

	@Autowired
	MessageServiceContext messageServiceContext;

	@Test
	public void test() {
		// 构建一个文本消息
		MessageInfo messageInfo = new MessageInfo(MSG_TYPE.TEXT.code, "消息内容");
		MessageService messageService = messageServiceContext.getMessageService(messageInfo.getType());
		// 处理文本消息 消息内容
		// 可以看到文本消息被文本处理类所处理
		messageService.handleMessage(messageInfo);
	}

}
