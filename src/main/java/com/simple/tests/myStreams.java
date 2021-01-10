package com.simple.tests;

import java.util.stream.IntStream;

import org.junit.Test;

public class myStreams {

	public boolean mystream(String str) { // streams cookbook

		IntStream s = IntStream.range(0, 25);

//		s.forEach(System.out::print);
//		System.out.println();

//		int[] a = s.toArray();
//		for (int i : a)
//			System.out.print(i);
//
//		System.out.println();
//		System.out.println("  ------  ");

		// Both works
		int[] b = IntStream.range(0, 25).filter(x -> x % 5 == 0).toArray();
//		int[] b = IntStream.range(0, 25).filter(x -> x % 5 == 0).boxed().mapToInt(Integer::new).toArray();

		for (int i : b)
			System.out.print(i + " ");

		return true;
	}

	@Test
	public void testThis3() {
		mystream("");
//		Assert.assertEquals(mystream(""), true);
//		Assert.assertEquals(pd.isPalindrome3("hello"), false);
//		Assert.assertEquals(pd.isPalindrome3("madam"), true);
	}

	@Test
	public void testThis4() {
		mystream("");
		// This is more of a test
		// More test
	}

}
