/**
 * LEKU APPLIANCE CHAINS.
 * Copyright (c) 2016-2016 All Rights Reserved.
 */
package com.jellyleo.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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

	@BeforeEach
	public void init() {

		System.out.println("\033[32;1m" + "************开始测试************" + "\033[0m");

	}

	@AfterEach
	public void after() {

		System.out.println("\033[31;1m" + "************结束测试************" + "\033[0m");
	}

}
