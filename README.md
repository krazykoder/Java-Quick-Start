
# this repository is updated for Java learning only


> "# krazy koder"

## Repo information 

This repository is a collection of advanced vs primitive java differences. 

![](img\capture.png)


```java
package com.simple.codes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.simple.tests.PalindromeCheck;

class PalindromeCheckTest {

	PalindromeCheck pd = new PalindromeCheck();
	@Test
	void testIsPalindrome() {
		Assert.assertEquals(pd.isPalindrome("madam"), true);
	}

	@Test
	void testIsPalindrome2() {
		Assert.assertEquals(pd.isPalindrome("hello"), false);
	}
	
	@Test
	void testTestthis2() {
//		fail("Not yet implemented");
	}

}
```
```java
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
}
```
