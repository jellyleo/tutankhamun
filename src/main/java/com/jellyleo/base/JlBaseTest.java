/**
 * LEKU APPLIANCE CHAINS.
 * Copyright (c) 2016-2016 All Rights Reserved.
 */
package com.jellyleo.base;

import org.junit.After;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 功能描述:
 *
 * @author Jelly
 * @created 2019年11月22日
 * @version 1.0.0
 */
@SpringBootTest
public class JlBaseTest {

	@Before
	public void init() {

		System.out.println("开始测试-----------------");

	}

	@After
	public void after() {

		System.out.println("测试结束-----------------");
	}

}
