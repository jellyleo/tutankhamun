package com.jellyleo.stream;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import com.jellyleo.base.JlBaseTest;

/**
 * 
 * 功能描述:
 *
 * @author Jelly
 * @created 2019年11月22日
 * @version 1.0.0
 */
public class StreamApiTest extends JlBaseTest {

	/*
	 * map 操作符要求输入一个Function的函数是接口实例，功能是将T类型转换成R类型的。
	 */
	@Test
	public void map() {
		Stream.of("apple", "banana", "orange", "waltermaleon", "grape").map(e -> e.length()) // 转成单词的长度 int
				.forEach(e -> System.out.println(e)); // 输出

		Stream.of("apple", "banana", "orange", "waltermaleon", "grape").map(String::length) // 转成单词的长度 int
				.forEach(System.out::println);
	}

	@Test
	public void mapToInt() {
		Stream.of("apple", "banana", "orange", "waltermaleon", "grape").mapToInt(e -> e.length()) // 转成int
				.forEach(e -> System.out.println(e));
	}

	@Test
	public void mapToLong() {
		Stream.of("apple", "banana", "orange", "waltermaleon", "grape").mapToLong(e -> e.length()) // 转成int
				.forEach(e -> System.out.println(e));
	}

	@Test
	public void mapToDouble() {
		Stream.of("apple", "banana", "orange", "waltermaleon", "grape").mapToDouble(e -> e.length()) // 转成Double，自动类型转换成Double
				.forEach(e -> System.out.println(e));
	}

	/*
	 * flatmap 作用就是将元素拍平拍扁 ，将拍扁的元素重新组成Stream，并将这些Stream 串行合并成一条Stream
	 */
	@Test
	public void flatmap() {
		Stream.of("a-b-c-d", "e-f-i-g-h").flatMap(e -> Stream.of(e.split("-"))).forEach(e -> System.out.println(e));
	}

	/*
	 * limit 限制元素的个数，只需传入 long 类型 表示限制的最大数
	 */
	@Test
	public void limit() {
		Stream.of(1, 2, 3, 4, 5, 6).limit(3) // 限制三个
				.forEach(e -> System.out.println(e)); // 将输出 前三个 1，2，3
	}

	/*
	 * distinct 将根据equals 方法进行判断，如果要对自己自定义的bean 去重，则需要 重写equals方法
	 */
	@Test
	public void distinct() {
		Stream.of(1, 2, 3, 1, 2, 5, 6, 7, 8, 0, 0, 1, 2, 3, 1).distinct() // 去重
				.forEach(e -> System.out.println(e));
	}

	/*
	 * filter 对某些元素进行过滤，不符合筛选条件的将无法进入流的下游
	 */
	@Test
	public void filter() {
		Stream.of(1, 2, 3, 1, 2, 5, 6, 7, 8, 0, 0, 1, 2, 3, 1).filter(e -> e >= 5) // 过滤小于5的
				.forEach(e -> System.out.println(e));
	}

	/*
	 * peek 挑选 ，将元素挑选出来，可以理解为提前消费
	 */
	@Test
	public void peek() {
		User w = new User("w", 10);
		User x = new User("x", 11);
		User y = new User("y", 12);

		Stream.of(w, x, y).peek(e -> {
			e.setName(e.getAge() + e.getName());
		}) // 重新设置名字 变成 年龄+名字
				.forEach(e -> System.out.println(e.toString()));
	}

	@Test
	public void skip() {
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).skip(4) // 跳过前四个
				.forEach(e -> System.out.println(e)); // 输出的结果应该只有5，6，7，8，9
	}

	/*
	 * sorted 排序 底层依赖Comparable 实现，也可以提供自定义比较器，这里Integer 实现了比较器
	 */
	@Test
	public void sorted() {
		Stream.of(2, 1, 3, 6, 4, 9, 6, 8, 0).sorted().forEach(e -> System.out.println(e));
	}

	/*
	 * 这里使用自定义比较，User也可以实现Comparable 接口
	 */
	@Test
	public void sorted1() {
		User x = new User("x", 11);
		User y = new User("y", 12);
		User w = new User("w", 10);

		Stream.of(w, x, y).sorted((e1, e2) -> e1.getAge() > e2.getAge() ? 1 : e1.getAge() == e2.getAge() ? 0 : -1)
				.forEach(e -> System.out.println(e.toString()));
	}

	/*
	 * collect 收集，使用系统提供的收集器可以将最终的数据流收集到List，Set，Map等容器中。
	 */
	@Test
	public void collect() {
		Stream.of("apple", "banana", "orange", "waltermaleon", "grape").collect(Collectors.toSet()) // set 容器
				.forEach(e -> System.out.println(e));
	}

	/*
	 * forEach不仅仅是是Stream 中的操作符，还是各种集合中得一个语法糖
	 */
	@Test
	public void sugar() {
		Set<String> stringSet = Stream.of("apple", "banana", "orange", "waltermaleon", "grape")
				.collect(Collectors.toSet()); // 收集的结果就是set
		stringSet.forEach(e -> System.out.println(e)); // set的语法糖forEach
	}

	/*
	 * count 统计数据流中的元素个数，返回的是long 类型
	 */
	@Test
	public void count() {
		long count = Stream.of("apple", "banana", "orange", "waltermaleon", "grape").count();
		System.out.println(count);
	}

	/*
	 * findFirst 获取流中的第一个元素
	 */
	@Test
	public void findFirst() {
		Optional<String> stringOptional = Stream.of("apple", "banana", "orange", "waltermaleon", "grape").findFirst();
		stringOptional.ifPresent(e -> System.out.println(e));
	}

	/*
	 * findAny 获取流中任意一个元素
	 */
	@Test
	public void findAny() {
		Optional<String> stringOptional = Stream.of("apple", "banana", "orange", "waltermaleon", "grape").parallel()
				.findAny(); // 在并行流下每次返回的结果可能一样也可能不一样
		stringOptional.ifPresent(e -> System.out.println(e));
	}

	/*
	 * 判断数据流中 一个都没有与条件匹配的元素 allMatch、anyMatch 一个是全匹配，一个是任意匹配 和noneMatch 类似
	 */
	@Test
	public void noneMatch() {
		boolean result = Stream.of("aa", "bb", "cc", "aa").noneMatch(e -> e.equals("aa"));
		System.out.println(result);
	}

	/*
	 * min 最小的一个，传入比较器，也可能没有(如果数据流为空)，max同
	 */
	@Test
	public void min() {
		Optional<Integer> integerOptional = Stream.of(0, 9, 8, 4, 5, 6, -1).min((e1, e2) -> e1.compareTo(e2));

		integerOptional.ifPresent(e -> System.out.println(e));
	}

	/*
	 * reduce 是一个规约操作，所有的元素归约成一个，比如对所有元素求和，乘啊等。
	 */
	@Test
	public void reduce() {
		int sum = Stream.of(0, 9, 8, 4, 5, 6, -1).reduce(0, (e1, e2) -> e1 + e2);
		System.out.println(sum);
	}

	/*
	 * forEachOrdered 适用用于并行流的情况下进行迭代，能保证迭代的有序性
	 */
	@Test
	public void forEachOrdered() {
		Stream.of(0, 2, 6, 5, 4, 9, 8, -1).parallel().forEachOrdered(e -> {
			System.out.println(Thread.currentThread().getName() + ": " + e);
		});
	}

	/*
	 * toArray 转成数组，可以提供自定义数组生成器
	 */
	@Test
	public void toArray() {
		Object[] objects = Stream.of(0, 2, 6, 5, 4, 9, 8, -1).toArray();

		for (int i = 0; i < objects.length; i++) {
			System.out.println(objects[i]);
		}
	}
}
