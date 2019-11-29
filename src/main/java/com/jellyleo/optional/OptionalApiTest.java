package com.jellyleo.optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;

import com.jellyleo.base.JlBaseTest;

/**
 * 
 * 功能描述:Optional常用api
 *
 * @author Jelly
 * @created 2019年11月22日
 * @version 1.0.0
 */
public class OptionalApiTest extends JlBaseTest {

	@Test(expected = NoSuchElementException.class)
	public void whenCreateEmptyOptional_thenNull() {
		Optional<User> emptyOpt = Optional.empty();
		emptyOpt.get();
	}

	/*
	 * 如果你把 null 值作为参数传递进去，of() 方法会抛出 NullPointerException： 如果对象即可能是 null 也可能是非
	 * null，你就应该使用 ofNullable() 方法：
	 */
	@Test(expected = NullPointerException.class)
	public void whenCreateOfEmptyOptional_thenNullPointerException() {
		User user = null;
//		Optional<User> opt = Optional.of(user);
	    Optional<User> opt = Optional.ofNullable(user);
		opt.get();
	}

	/*
	 * 这个方法会在值为 null 的时候抛出异常
	 */
	@Test
	public void whenCreateOfNullableOptional_thenOk() {
		String name = "John";
		Optional<String> opt = Optional.ofNullable(name);

		assertEquals("John", opt.get());
	}

	/*
	 * 要避免异常，你可以选择首先验证是否有值：
	 */
	@Test
	public void whenCheckIfPresent_thenOk() {
		User user = new User("john@gmail.com", "1234");
		Optional<User> opt = Optional.ofNullable(user);
		assertTrue(opt.isPresent());
		assertEquals(user.getEmail(), opt.get().getEmail());
		// 检查是否有值的另一个选择是 ifPresent() 方法。该方法除了执行检查，还接受一个Consumer(消费者) 参数，如果对象不是空的，就对执行传入的
		// Lambda 表达式
		opt.ifPresent(u -> assertEquals(user.getEmail(), u.getEmail()));
	}

	/*
	 * orElse(),如果有值则返回该值，否则返回传递给它的参数值：
	 */
	@Test
	public void whenEmptyValue_thenReturnDefault() {
		User user = null;
		User user2 = new User("anna@gmail.com", "1234");
		User result = Optional.ofNullable(user).orElse(user2);

		assertEquals(user2.getEmail(), result.getEmail());
	}

	/*
	 * 如果对象的初始值不是 null，那么默认值会被忽略：
	 */
	@Test
	public void whenValueNotNull_thenIgnoreDefault() {
		User user = new User("john@gmail.com", "1234");
		User user2 = new User("anna@gmail.com", "1234");
		User result = Optional.ofNullable(user).orElse(user2);

		// orElseGet() —— 其行为略有不同。这个方法会在有值的时候返回值，如果没有值，它会执行作为参数传入的 Supplier(供应者)
		// 函数式接口，并将返回其执行结果：
		User result1 = Optional.ofNullable(user).orElseGet(() -> user2);

		assertEquals("john@gmail.com", result.getEmail());
		assertEquals("john@gmail.com", result1.getEmail());
	}

	/*
	 * 当对象为空而返回默认对象时，行为并无差异。
	 */
	@Test
	public void givenEmptyValue_whenCompare_thenOk() {
		User user = null;
		System.out.println("Using orElse");
		Optional.ofNullable(user).orElse(createNewUser());
		System.out.println("Using orElseGet");
		Optional.ofNullable(user).orElseGet(() -> createNewUser());
	}

	/*
	 * 非空值， orElse() 方法仍然创建了 User 对象。与之相反，orElseGet() 方法不创建 User 对象。
	 */
	@Test
	public void givenPresentValue_whenCompare_thenOk() {
		User user = new User("john@gmail.com", "1234");
		System.out.println("Using orElse");
		Optional.ofNullable(user).orElse(createNewUser());
		System.out.println("Using orElseGet");
		Optional.ofNullable(user).orElseGet(() -> createNewUser());
	}

	private User createNewUser() {
		System.out.println("Creating New User");
		return new User("extra@gmail.com", "1234");
	}

	/*
	 * 如果 user 值为 null，会抛出 IllegalArgumentException。
	 */
	@Test(expected = IllegalArgumentException.class)
	public void whenThrowException_thenOk() {
		User user = null;
		Optional.ofNullable(user).orElseThrow(() -> new IllegalArgumentException());
	}

	/*
	 * map() 对值应用(调用)作为参数的函数，然后将返回的值包装在 Optional 中
	 */
	@Test
	public void whenMap_thenOk() {
		User user = new User("anna@gmail.com", "1234");
		String email = Optional.ofNullable(user).map(u -> u.getEmail()).orElse("default@gmail.com");

		assertEquals(email, user.getEmail());
	}

	@Test
	public void whenFlatMap_thenOk() {
		User user = new User("anna@gmail.com", "1234");
		user.setPosition("Developer");
		String position = Optional.ofNullable(user).flatMap(u -> u.getPosition()).orElse("default");

		assertEquals(position, user.getPosition().get());
	}

	/*
	 * filter() 接受一个 Predicate 参数，返回测试结果为 true 的值。如果测试结果为 false，会返回一个空的 Optional。
	 */
	@Test
	public void whenFilter_thenOk() {
		User user = new User("anna@gmail.com", "1234");
		Optional<User> result = Optional.ofNullable(user)
				.filter(u -> u.getEmail() != null && u.getEmail().contains("@"));

		assertTrue(result.isPresent());
	}

	/*
	 * 为了更充分的使用 Optional，可以链接组合其大部分方法，因为它们都返回相同类似的对象。
	 */
	@Test
	public void whenChaining_thenOk() {
		User user = new User("anna@gmail.com", "1234");

		String result = Optional.ofNullable(user).flatMap(u -> u.getAddress()).flatMap(a -> a.getCountry())
				.map(c -> c.getIsocode()).orElse("default");

		String result1 = Optional.ofNullable(user).flatMap(User::getAddress).flatMap(Address::getCountry)
				.map(Country::getIsocode).orElse("default");

		assertEquals(result, "default");
		assertEquals(result1, "default");
	}
}
