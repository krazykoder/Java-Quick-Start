package com.tow.core;

public class streamsAPI {

	public void basic() {

//		# 2.1. Stream.of()
//		## creating a stream of a fixed number of integers.

//		# 2.2. Stream.of(array)
//		## Creating a stream from the array. The elements in the stream are taken from the array.
//

//
//		# 2.3. List.stream()
//		## Creating a stream from the List. The elements in the stream are taken from the List.
//

//
//
//
//		# 2.4. Stream.generate() or Stream.iterate()
//		## Creating a stream from generated elements. This will produce a stream of 20 random numbers. We have restricted the elements count using limit() function.
//

//
//		# 2.5. Stream of String chars or tokens
//
//		## First, creating a stream from the characters of a given string. In the second part, we are creating the stream of tokens received from splitting from a string.
//
//		    

//
//		# 3. Stream Collectors
//
//		## After performing the intermediate operations on elements in the stream, we can collect the processed elements again into a Collection using the stream Collector methods.
//

//		# 3.1. Collect Stream elements to a List
//
//		## first, we are creating a stream on integers 1 to 10. Then we are processing the stream elements to find all even numbers. At last, we are collecting all even numbers into a List.
//
//		    
//
//
//		# 3.2. Collect Stream elements to an Array
//
//		## Write an code similar to the first example shown above. The only difference is that we are collecting the even numbers in an Array. There are plenty of other ways also to collect stream into a Set, Map or into multiple ways. Just go through Collectors class and try to keep them in mind.
//
//
//		   
//
//
//
//		# 4. Stream Operations
//		Stream abstraction has a long list of useful functions. Let us look at a few of them.
//
//		## build a List of strings beforehand. We will build our examples on this list so that it is easy to relate and understand.
//
//		    List<String> memberNames = new ArrayList<>();
//		    memberNames.add("Amitabh");
//		    memberNames.add("Shekhar");
//		    memberNames.add("Aman");
//		    memberNames.add("Rahul");
//		    memberNames.add("Shahrukh");
//		    memberNames.add("Salman");
//		    memberNames.add("Yana");
//		    memberNames.add("Lokesh");
//
//		These core methods have been divided into 2 parts given below:
//
//		# 4.1. Intermediate Operations
//		Intermediate operations return the stream itself so you can chain multiple methods calls in a row. Let’s learn important ones.
//
//		# 4.1.1. Stream.filter()
//
//		The filter() method accepts a Predicate to filter all elements of the stream. This operation is intermediate which enables us to call another stream operation (e.g. forEach()) on the result.
//
//		## Write an example that filters a list of strings starting with 'A' and prints them
//

//
//
//		# 4.1.2. Stream.map()
//		The map() intermediate operation converts each element in the stream into another object via the given function.
//
//		## Write an example that converts each string into an UPPERCASE string. But we can use map() to transform an object into another type as well.
//

//
//		# 4.1.2. Stream.sorted()
//		The sorted() method is an intermediate operation that returns a sorted view of the stream. The elements in the stream are sorted in natural order unless we pass a custom Comparator.
//
//		## Given a list of strings, write an example that SORTS and then converts each string into an UPPERCASE string. But we can use map() to transform an object into another type as well.
//
//		    memberNames.stream().sorted()
//		                        .map(String::toUpperCase)
//		                        .forEach(System.out::println);
//
//		    Program Output:
//		    AMAN
//		    AMITABH
//		    LOKESH
//		    RAHUL
//		    SALMAN
//		    SHAHRUKH
//		    SHEKHAR
//		    YANA
//
//		    Please note that the sorted() method only creates a sorted view of the stream without manipulating the ordering of the source Collection. In this example, the ordering of string in the memberNames is untouched.
//
//		# 4.2. Terminal operations
//
//		Terminal operations return a result of a certain type after processing all the stream elements.
//		Once the terminal operation is invoked on a Stream, the iteration of the Stream and any of the chained streams will get started. Once the iteration is done, the result of the terminal operation is returned.
//
//		# 4.2.1. Stream.forEach()
//
//		The forEach() method helps in iterating over all elements of a stream and perform some operation on each of them. The operation to be performed is passed as the lambda expression.
//
//		## Given a list of strings, use foreach to
//

//
//		# 4.2.2. Stream.collect()
//
//		    The collect() method is used to receive elements from a steam and store them in a collection.
//		    List<String> memNamesInUppercase = memberNames.stream().sorted()
//		                                .map(String::toUpperCase)
//		                                .collect(Collectors.toList());
//		         
//		    System.out.print(memNamesInUppercase);
//
//		    Program Output:
//		    [AMAN, AMITABH, LOKESH, RAHUL, SALMAN, SHAHRUKH, SHEKHAR, YANA]
//
//
//		#4.2.3. Stream.match()
//
//		Various matching operations can be used to check whether a given predicate matches the stream elements. All of these matching operations are terminal and return a boolean result.
//
//		    boolean matchedResult = memberNames.stream()
//		            .anyMatch((s) -> s.startsWith("A"));
//		     
//		    System.out.println(matchedResult);
//		     
//		    matchedResult = memberNames.stream()
//		            .allMatch((s) -> s.startsWith("A"));
//		     
//		    System.out.println(matchedResult);
//		     
//		    matchedResult = memberNames.stream()
//		            .noneMatch((s) -> s.startsWith("A"));
//		     
//		    System.out.println(matchedResult);
//
//		    Program Output:
//		    true
//		    false
//		    false
//		    4.2.4. Stream.count()
//
//
//		## The count() is a terminal operation returning the number of elements in the stream as a long value.
//
//		    long totalMatched = memberNames.stream()
//		        .filter((s) -> s.startsWith("A"))
//		        .count();
//		     
//		    System.out.println(totalMatched);
//
//		    Program Output:
//		    2
//
//
//		# 4.2.5. Stream.reduce()
//		The reduce() method performs a reduction on the elements of the stream with the given function. The result is an Optional holding the reduced value.
//
//		## In the given example, we are reducing all the strings by concatenating them using a separator #.
//

		//
//		## Get the longest word in a list of words
//

//

	}
}
