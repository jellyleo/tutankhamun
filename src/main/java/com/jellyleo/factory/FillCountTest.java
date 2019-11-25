/**
 * LEKU APPLIANCE CHAINS.
 * Copyright (c) 2016-2016 All Rights Reserved.
 */
package com.jellyleo.factory;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.jellyleo.base.JlBaseTest;

/**
 * 功能描述:
 *
 * @author Jelly
 * @created 2019年11月25日
 * @version 1.0.0
 */
public class FillCountTest extends JlBaseTest {

	@Test
	public void getCountRecoder() {
		List<CountEntry> countEntries = new ArrayList<>();
		countEntries.add(new CountEntry(1, 11));
		countEntries.add(new CountEntry(2, 22));
		countEntries.add(new CountEntry(3, 33));
		countEntries.add(new CountEntry(4, 44));
		countEntries.add(new CountEntry(5, 55));
		countEntries.add(new CountEntry(6, 66));
		CountRecoder countRecoder = new CountRecoder();
		countEntries.stream().forEach(countEntry -> FillCountServieFactory.getFillCountStrategy(countEntry.getCode())
				.fillCount(countRecoder, countEntry.getCount()));
		System.out.println(countRecoder);
	}
}
