package com.tow.core;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamsAPIRevision {

	@Test
	public void revise() {
		Integer[] numbers = new Integer[] { 1, 2, 4, 5, 7, 8, 6 };
		int[] pnums = new int[] { 1, 2, 4, 5, 7, 8, 6 };

//		List<int> lp = Arrays.asList(pnums);
		Integer[] s = Stream.of(pnums).toArray(Integer[]::new);

		System.out.println(s);

		Integer[] boxedArray = Arrays.stream(pnums) // IntStream
				.boxed() // Stream<Integer>
				.toArray(Integer[]::new);

		System.out.println(boxedArray);

	}

}
