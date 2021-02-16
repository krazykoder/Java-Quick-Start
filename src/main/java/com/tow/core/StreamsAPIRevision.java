package com.tow.core;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;

public class StreamsAPIRevision {

	@Test
	public void reduceEx_Integers() {
		Integer[] nums = new Integer[] { 1, 2, 4, 5, 7, 8, 6 };
		int[] pnums = new int[] { 4, 12, 44, 15, 17, 28, 26 };

//		List<int> lp = Arrays.asList(pnums); // cannot create List <primitives>

		Integer[] s = Arrays.stream(pnums) // IntStream
				.boxed() // Stream <Integer>
				.toArray(Integer[]::new); // Integer []

		for (Integer integer : s) { // print it out
			System.out.print(integer + ",");
		}
		System.out.println();

		// Find sum of Integer [] using 2 methods
		// m1
		System.out.println(Arrays.stream(nums).reduce(0, (x, y) -> x + y));
		// m2
		System.out.println(Arrays.stream(nums).mapToInt(Integer::new).sum());

		// Find sum of int [] using 2 methods
		// m1
		System.out.println(Arrays.stream(pnums).reduce(0, (x, y) -> x + y));
		System.out.println(Arrays.stream(pnums).reduce(0, Integer::sum));
		// m2
		System.out.println(Arrays.stream(pnums).sum());
		System.out.println(Arrays.stream(pnums) // IntStream
				.boxed() // Stream<Integer>
				.mapToInt(Integer::new) // IntStream
				.sum()); // Sum

	}

//	@Test
	public void reduceEx_Strings() {
		String[] strings = { "Hello", "Me", "c", "d", "Power", "Done" };

		// |a|b|c|d|e , the initial | join is not what we want
		String reduce = Arrays.stream(strings).reduce("", (a, b) -> a + "|" + b);

// ADD elements of an array with length > 1 separated by '!'

		// Method 1: Correct Way to add elements with length > 1
		Optional<String> reduce2 = Arrays.stream(strings).reduce((a, b) -> {
			if (a.length() > 1 && b.length() > 1)
				return a + "!" + b;
			else if (a.length() > 1)
				return a;
			else if (b.length() > 1)
				return b;
			else
				return "Not Found";
		});
		reduce2.ifPresent(System.out::print);
		System.out.println();
//		System.out.println(reduce2);

		// Method 2:
		Optional<String> myString = Arrays.stream(strings).filter(x -> x.length() > 2).reduce((x, y) -> x + "!" + y);
		myString.ifPresent(System.out::println);
		System.out.println(myString);

// WRONG METHOD to use reduce
//		Optional<String> reduce3 = Arrays.stream(strings).reduce((a, b) -> {
//			if (a.length() > 1 && b.length() > 1)
//				return a + "!" + b;
//			else
//				return b;
//		});
//
//		reduce3.ifPresent(System.out::print);

	}
}
