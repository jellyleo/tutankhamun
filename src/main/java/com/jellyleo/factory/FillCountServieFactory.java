/**
 * LEKU APPLIANCE CHAINS.
 * Copyright (c) 2016-2016 All Rights Reserved.
 */
package com.jellyleo.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 *
 * @author Jelly
 * @created 2019年11月25日
 * @version 1.0.0
 */
public class FillCountServieFactory {

	private static Map<Integer, FillCountService> fillCountServiceMap = new HashMap<>();

	static {
		fillCountServiceMap.put(1, (countRecoder, count) -> countRecoder.setCountOfFirstStage(count));
		fillCountServiceMap.put(2, (countRecoder, count) -> countRecoder.setCountOfSecondStage(count));
		fillCountServiceMap.put(3, (countRecoder, count) -> countRecoder.setCountOfThirdStage(count));
		fillCountServiceMap.put(4, (countRecoder, count) -> countRecoder.setCountOfFourthStage(count));
		fillCountServiceMap.put(5, (countRecoder, count) -> countRecoder.setCountOfFirthStage(count));
		fillCountServiceMap.put(6, (countRecoder, count) -> countRecoder.setCountOfSixthStage(count));
	}

	public static FillCountService getFillCountStrategy(int statusCode) {
		return fillCountServiceMap.get(statusCode);
	}
}
