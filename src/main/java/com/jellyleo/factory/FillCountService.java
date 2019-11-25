/**
 * LEKU APPLIANCE CHAINS.
 * Copyright (c) 2016-2016 All Rights Reserved.
 */
package com.jellyleo.factory;

/**
 * 功能描述:
 *
 * @author Jelly
 * @created 2019年11月25日
 * @version 1.0.0
 */
@FunctionalInterface
public interface FillCountService {

    void fillCount(CountRecoder countRecoder, int count);
}
