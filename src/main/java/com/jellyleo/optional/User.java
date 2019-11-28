/**
 * LEKU APPLIANCE CHAINS.
 * Copyright (c) 2016-2016 All Rights Reserved.
 */
package com.jellyleo.optional;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述:
 *
 * @author Jelly
 * @created 2019年11月28日
 * @version 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private Address address;
	private String position;
	private String email;

	public Optional<String> getPosition() {
		return Optional.ofNullable(position);
	}

	public Optional<Address> getAddress() {
		return Optional.ofNullable(address);
	}

	public User(String email, String position) {
		super();
		this.email = email;
		this.position = position;
	}
}
