package com.tow.core.Streams;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.Test;

public class streams_function_tests {

	/*
	 * Stream.reduce() is a general-purpose method for generating our custom
	 * reduction operations.
	 * 
	 * Optional<T> reduce(BinaryOperator<T> accumulator)
	 * 
	 * This method performs a reduction on the elements of this stream, using an
	 * associative accumulation function. It returns an Optional describing the
	 * reduced value, if any.
	 * 
	 * T reduce(T identity, BinaryOperator<T> accumulator)
	 * 
	 * This method takes two parameters: the identity and the accumulator. The
	 * identity element is both the initial value of the reduction and the default
	 * result if there are no elements in the stream. The accumulator function takes
	 * two parameters: a partial result of the reduction and the next element of the
	 * stream. It returns a new partial result. The Stream.reduce() method returns
	 * the result of the reduction.
	 * 
	 */

//	@Test
	public void stream_reduce() {

		// simple examples reduce ()
		IntStream.range(1, 4).forEach(System.out::print);
		System.out.println();
		// product of int stream
		System.out.println(IntStream.range(1, 6).reduce((num1, num2) -> num1 * num2).orElse(-1));
		System.out.println(IntStream.range(1, 6).reduce((num1, num2) -> num1 / num2).orElse(-1));
		// sum of a stream
		System.out.println(IntStream.range(1, 6).reduce((num1, num2) -> num1 + num2).orElse(-1));
		// sum of a stream
		System.out.println(IntStream.range(1, 6).reduce(0, (element1, element2) -> element1 + element2)); // use
		// sum of all even numbers in a list of Integers using reduce method
		System.out
				.println(IntStream.range(1, 6).filter(x -> x % 2 == 0).reduce((num1, num2) -> num1 + num2).orElse(-1));
		System.out.println(IntStream.range(1, 6).filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i));
	}

//	@Test // https://zetcode.com/java/streamreduce/
	public void stream_reduce_advanced_example() {
		IntStream.range(1, 10).reduce((x, y) -> x + y).ifPresent(s -> System.out.println(s));
		IntStream.range(1, 10).reduce(Integer::sum).ifPresent(s -> System.out.println(s));
		IntStream.range(1, 10).reduce(MyUtil::add2Ints).ifPresent(s -> System.out.println(s));
	}

	@Test // https://zetcode.com/java/streamreduce/
	public void stream_reduce_objects() {
		List<Car> persons = Arrays.asList(new Car("Skoda", 18544), new Car("Volvo", 22344), new Car("Fiat", 23650),
				new Car("Renault", 19700));

		Optional<Car> car = persons.stream().reduce((c1, c2) -> c1.getPrice() > c2.getPrice() ? c1 : c2);

		car.ifPresent(System.out::println);
	}

	@Test // https://zetcode.com/java/streamreduce/
	public void stream_reduce_objects2() {
		List<User> users = new ArrayList<>();
		users.add(new User("Frank", LocalDate.of(1979, 11, 23)));
		users.add(new User("Peter", LocalDate.of(1985, 1, 18)));
		users.add(new User("Lucy", LocalDate.of(2002, 5, 14)));
		users.add(new User("Albert", LocalDate.of(1996, 8, 30)));
		users.add(new User("Frank", LocalDate.of(1967, 10, 6)));

//		int maxAge = users.stream().mapToInt(User::getAge).reduce(0, (a1, a2) -> a1 > a2 ? a1 : a2);
		int maxAge = users.stream().mapToInt(User::getAge).reduce(0, (a1, a2) -> a1 > a2 ? a1 : a2);

		System.out.printf("The oldest user's age: %s%n", maxAge);
	}

}

class Car {

	private final String name;
	private final int price;

	public Car(String name, int price) {

		this.name = name;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car{name=").append(name).append(", price=").append(price).append("}");

		return builder.toString();
	}
}

class MyUtil {

	public static int add2Ints(int num1, int num2) {
		return num1 + num2;
	}
}

class User {

	private String name;
	private LocalDate dateOfBirth;

	public User(String name, LocalDate dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		return dateOfBirth.until(IsoChronology.INSTANCE.dateNow()).getYears();
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append("User{name=").append(name).append(", dateOfBirth=").append(dateOfBirth).append("}");

		return builder.toString();
	}
}