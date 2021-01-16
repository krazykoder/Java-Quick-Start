package com.tow.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LamdaAPI {

	/*
	 * # Java 8 Lambda Expressions Lambda expressions are nameless functions given
	 * as constant values, and written exactly in the place where it’s needed,
	 * typically as a parameter to some other function.
	 * 
	 * # The Syntax and some examples :: (parameters) -> expression
	 * 
	 * 
	 * # A lambda expression can have zero, one or more parameters. (x, y) -> x + y
	 * // 2 parameter () -> expressions No parameter (param1, param2, param3) ->
	 * expression (parameters) -> { statements; }
	 */

	// ## Use lambda expression to iterate over a List and perform some action on
	// list elements

	public void basic() {
		List<String> pointList = new ArrayList();
		pointList.add("1");
		pointList.add("2");
		pointList.forEach(p -> {
			System.out.println(p);
		});

	}

	/*
	 * # Java 8 Functional Interface Single Abstract Method interfaces (SAM
	 * Interfaces) is not a new concept. It means interfaces with only one single
	 * method. In Java, we already have many examples of such SAM interfaces. Java 8
	 * enforces the rule of single responsibility by marking these interfaces with a
	 * new annotation i.e. @FunctionalInterface.
	 * 
	 * Example: new definition of Runnable interface is like this:
	 * 
	 * @FunctionalInterface public interface Runnable { public abstract void run();
	 * }
	 * 
	 * Two good examples of functional interface type are Consumer and BiConsumer
	 * interfaces.
	 * 
	 * We write a thread like this in standard Java
	 * 
	 * new Thread(new Runnable() {
	 * 
	 * @Override public void run() { System.out.println("howtodoinjava"); }
	 * }).start();
	 * 
	 * With Lambda Expression
	 * 
	 * new Thread( () -> { System.out.println("My Runnable"); } ).start();
	 * 
	 */

	// ## only one abstract method allowed in a functional interface

	@FunctionalInterface
	public interface MyFirstFunctionalInterface {

		public void firstWork(); // abstract method

		default void doSomeMoreWork1() {
			// Method body
		}

		default void doSomeMoreWork2() {
			// Method body
		}
	}

	// ## Abstract method can override one of the public methods in java.lang.Object

	@FunctionalInterface
	public interface MyFirstFunctionalInterface2 {
		public void firstWork();

		@Override
		public String toString(); // Overridden from Object class

		@Override
		public boolean equals(Object obj); // Overridden from Object class
	}

	/*
	 * # Java 8 Method References
	 * 
	 * Syntax :
	 * 
	 * Class::staticMethodName
	 * 
	 * Math::max equivalent to Math.max(x,y) System.out::println equivalent to
	 * System.out.println(x) String::length equivalent to str.length()
	 * ArrayList::new equivalent to new ArrayList()
	 * 
	 * ## Write a code to find the max value in a List of Integers
	 * 
	 * List<Integer> integers = Arrays.asList(1,12,433,5); Optional<Integer> max =
	 * integers.stream().reduce( Math::max ); max.ifPresent( System.out::println );
	 * 
	 */
	// # Java 8 Optionals

	public void basic2() {
		Optional<String> opt = Optional.of("baeldung");
		opt.ifPresent(name -> System.out.println(name.length()));

		Optional<String> opt3 = Optional.of("baeldung");
		opt3.ifPresent(name -> System.out.println(name));

		Optional<String> opt2 = Optional.of(null);
		opt2.ifPresent(name -> System.out.println(name));

		String text = null;

		String defaultText1 = Optional.ofNullable(text).orElse("Hello");
		String defaultText2 = Optional.ofNullable(text).orElseGet(() -> {
			return " Hello";
		});
	}

}
