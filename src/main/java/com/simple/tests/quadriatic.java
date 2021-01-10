package com.simple.tests;

import org.junit.Assert;
import org.junit.Test;

/*
 * A quadratic equation a x² + b x + c = 0 has either 0, 1, or 2 distinct solutions for real values of x. Given a, b and c, you should return the number of solutions to the equation.
Examples

solutions(1, 0, -1) ➞ 2
// x² - 1 = 0 has two solutions (x = 1 and x = -1).

solutions(1, 0, 0) ➞ 1
// x² = 0 has one solution (x = 0).

solutions(1, 0, 1) ➞ 0
// x² + 1 = 0 has no real solutions.
 
 */

public class quadriatic {

	public int solutions(int a, int b, int c) {
		double disc = Math.pow(b, 2) - 4 * a * c;
		System.out.println(disc);
		int numRoots = (disc < 0) ? 0 : (disc == 0) ? 1 : 2;
		System.out.println("# Roots = " + numRoots);
		return numRoots;

	}

	@Test
	public void testthis1() {
		quadriatic pd = new quadriatic();

		Assert.assertEquals(pd.solutions(10, 1, 1), 0);
		Assert.assertEquals(pd.solutions(5, 12, 1), 2);
		Assert.assertEquals(pd.solutions(4, 4, 1), 1);

//		Assert.assertEquals(pd.isPalindrome("hello"), false);
	}
	
	public static void main () { 
		String a = "Hello World. I am an Angel. " ; 
		
	}
	

}
