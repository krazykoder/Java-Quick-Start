package com.tow.core;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class streamAPI {

	@Test
	public void basicStreams() {

		List<String> names2 = Arrays.asList("Alex", "Brian", "Charles");

		// Consumer interface
		Consumer<String> makeUpperCase = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t.toUpperCase());
			}
		};

//		names.forEach(makeUpperCase);

//		names.forEach(p -> System.out.println(p.toUpperCase()));

//		names.forEach((p) -> {
//			System.out.println(p.toUpperCase());
//		});

//		# convert a list of primitive int to list of Integer ; square them and return a list of int

		int[] nums = new int[] { 1, 2, 4, 5, 7, 8, 6 };

		Arrays.stream(nums).boxed().collect(Collectors.toList());

//		# create a list of int of all even numbers from 1 to 20 
		int arr[] = IntStream.range(0, 20).filter(x -> x % 2 == 0).boxed().mapToInt(Integer::new).toArray();

//		for (int x : arr)
//			System.out.println(x);

//		# create a list of Integers of all even numbers from 1 to 20
		int arr3[] = IntStream.range(0, 20).filter(x -> x % 2 == 0).toArray();
//		for (int x : arr3)
//			System.out.println(x);

		// # convert a primitive int Array to list of Integer ; square them and return
		// a list of int

		Integer[] numbers = new Integer[] { 1, 2, 4, 5, 7, 8, 6 };
		int[] pnums = new int[] { 1, 2, 4, 5, 7, 8, 6 };

//		List<int> lp = Arrays.asList(pnums);
		Integer[] s = Stream.of(numbers).toArray(Integer[]::new);
		System.out.println(s);

//		Stream<Integer> s = Stream.of(numbers);
//				Stream<Integer> s = Stream.of(pnums); // error cannot convert int[] to Stream <Integers>
//		s.forEach(p -> System.out.println(p));

		// To a list
		List<Integer> resultList = Stream.of(numbers).filter(x -> x % 3 == 0).collect(Collectors.toList());
		// To an Integer Array
		Integer[] arrayInteger = Stream.of(numbers).filter(x -> x % 3 == 0).toArray(Integer[]::new);
		// To an int Array
		int[] arrayint = Stream.of(numbers).filter(x -> x % 2 == 0).mapToInt(Integer::new).toArray();

		// List of Integers -> return list of Integers only even numbers
		List<Integer> lint = Arrays.asList(1, 2, 4, 5, 7, 8, 6);

		List<String> names = Arrays.asList("Reflection", "Collection", "Stream");
		names.stream().filter(x -> x.startsWith("S")).collect(Collectors.toList()).forEach(System.out::print);
	}

//	@Test
	public void basic2() {
		// Sample arrays and lists
		Integer[] nums = new Integer[] { 1, 2, 4, 5, 7, 8, 6 };
		int[] pnums = new int[] { 4, 12, 44, 15, 17, 28, 26 };
		// create a list of integers
		List<Integer> number = Arrays.asList(2, 3, 4, 5, 7, 6, 8);

		// demonstration of map method and print the square of the elements in array
		List<Integer> square = number.stream().map(x -> x * x).collect(Collectors.toList());
		System.out.println(square);

		// create a list of String
		List<String> names = Arrays.asList("Reflection", "Collection", "Stream");

		// demonstration of filter method
		List<String> result = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
		System.out.println(result);

		// demonstration of sorted method
		List<String> show = names.stream().sorted().collect(Collectors.toList());
		System.out.println(show);

		// create a list of integers
		List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 2);

		// collect method returns a set
		Set<Integer> squareSet = numbers.stream().map(x -> x * x).collect(Collectors.toSet());
		System.out.println("Square Set ::" + squareSet);

		// demonstration of forEach method
		number.stream().map(x -> x * x).forEach(y -> System.out.println(y));

		// demonstration of reduce method
		int even = number.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);
		System.out.println(number);
		System.out.println("Sum of Even::" + even);
	}

//	@Test
	public void basic3() {
		// reduce() method

		// ## creating a list of Strings
		List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");

		// The result of the reduce() method is an Optional because the list on which
		// reduce() is called may be empty.

		// ## Get the longest word in a list of words
		Optional<String> longestString = words.stream()
				.reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);

		longestString.ifPresent(System.out::println);

		Optional<String> String_combine = words.stream().reduce((str1, str2) -> str1 + "-" + str2);
		String_combine.ifPresent(System.out::println);

		// ## get the sum of all elements in a Integer Array
		List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);
		// Finding sum of all elements
		int sum = array.stream().reduce(0, (element1, element2) -> element1 + element2);
		System.out.println(sum);

		// ## To get the product of all elements in given range excluding the rightmost
		// element
		int product = IntStream.range(2, 8).reduce((num1, num2) -> num1 * num2).orElse(-1);
		System.out.println(product);
	}

//	@Test
	public void basic4() {
//
//		String[] s = "A,B,C:".split(",");
//		for (String p : s)
//			System.out.println(p);
		Stream stream = Stream.of("A,B,C:".split(","));

		stream.forEach(p -> System.out.println(p));

		stream = Stream.generate(() -> {
			return (new Random()).nextInt(10);
		}).limit(5);

		stream.forEach(p -> System.out.print(p));
		System.out.println();

		Integer[] myInt = new Integer[] { 1, 2, 4, 5, 7, 8, 6 };

		Stream<Integer> istr = Stream.of(new Integer[] { 1, 2, 4, 5, 7, 8, 6 });

		List<Integer> R = istr.filter(x -> x % 2 == 0).collect(Collectors.toList());

		R.forEach(System.out::print);
		System.out.println();

		Optional<String> opt = Optional.of("baeldung");
		opt.ifPresent(name -> System.out.println(name));

		String text = null;
		Optional<String> opt2 = Optional.of(text);
		opt2.ifPresent(name -> System.out.println(name));

		String defaultText1 = Optional.ofNullable(text).orElse("Hello");
		String defaultText2 = Optional.ofNullable(text).orElseGet(() -> {
			return " Hello";
		});

	}

}
