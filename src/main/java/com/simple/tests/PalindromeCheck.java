package com.simple.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PalindromeCheck {

	public boolean isPalindrome(String str) { // method 1

		String newstr = new StringBuilder(str).reverse().toString();

		if (newstr.equals(str)) {
			System.out.println(str + " is palindrome. :) ");
			return true;
		} else
			return false;
	}

	public boolean isPalindrome2(String str) { // method 2

		// Pointers pointing to the beginning
		// and the end of the string
		int i = 0, j = str.length() - 1;

		// While there are characters to compare
		while (i < j) {

			// If there is a mismatch
			if (str.charAt(i) != str.charAt(j)) {

				System.out.println(str + " is palindrome ! :( ");
				return false;
			}

			// Increment first pointer and
			// decrement the other
			i++;
			j--;
		}
		System.out.println(str + " is palindrome. :) ");
		return true;
	}

	boolean isPalindrome3(String str) { // method 3

		String newstr = "";
		for (char c : str.toCharArray()) {
			newstr = c + newstr;
		}
		System.out.println("Reverse :" + newstr);

		if (newstr.equals(str)) {
			System.out.println(str + " is palindrome. :) ");
			return true;
		} else {
			System.out.println(str + " is NOT a palindrome. :( ");
			return false;
		}
	}

	/*
	 * Unit testing code
	 */

	PalindromeCheck pd;

	@Before
	public void init() {
		System.out.println("Startup");
		pd = new PalindromeCheck();
	}

	@Test
	public void testthis1() {
// this is a test code that can be used for testing one or more of the functions 
		Assert.assertEquals(pd.isPalindrome("madam"), true);
		Assert.assertEquals(pd.isPalindrome("hello"), false);
	}

	@After
	public void clear() {
		System.out.println("Done");
	}

	@Test
	public void testthis2() {
		System.out.println("Test 2");
		Assert.assertEquals(pd.isPalindrome2("hello"), false);
		Assert.assertEquals(pd.isPalindrome2("madam"), true);

	}

	@Test
	public void testthis3() {
		System.out.println("Test 2");
		Assert.assertEquals(pd.isPalindrome3("hello"), false);
		Assert.assertEquals(pd.isPalindrome3("madam"), true);

	}

//	static PalindromeCheck pd;
//
//	@BeforeClass
//	public static void init() {
//		System.out.println("Startup");
//		pd = new PalindromeCheck();
//	}

}
