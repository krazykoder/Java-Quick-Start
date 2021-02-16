A Stream in Java 8 can be defined as a sequence of elements from a source. Streams supports aggregate operations on the elements. The source of elements here refers to a Collection or Array that provides data to the Stream.

Stream keeps the ordering of the elements the same as the ordering in the source. The aggregate operations are operations that allow us to express common manipulations on stream elements quickly and clearly.

# 1.1 Java 8 forEach()
The forEach() method performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception.


## Iterate : Write a Java program to iterate over a List using forEach() and print each element 

    List<String> names = Arrays.asList("Alex", "Brian", "Charles");
         
    names.forEach(System.out::println);


## Creating consumer action through an interface class 

    List<String> names = Arrays.asList("Alex", "Brian", "Charles");
     
    Consumer<String> makeUpperCase = new Consumer<String>()
    {
        @Override
        public void accept(String t) 
        {
            System.out.println(t.toUpperCase());
        }
    };
     
    names.forEach(makeUpperCase);   


## Use forEach() to iterate over a Map using forEach()

    Map<String, String> map = new HashMap<String, String>();
     
    map.put("A", "Alex");
    map.put("B", "Brian");
    map.put("C", "Charles");
     
    map.forEach((k, v) -> 
        System.out.println("Key = " + k + ", Value = " + v));


## Create custom BiConsumer action which will take key-value pairs from a Map and process each entry one at a time.

    BiConsumer<String, Integer> action = (a, b) -> 
    { 
        //Process the entry here as per business
        System.out.println("Key is : " + a); 
        System.out.println("Value is : " + b); 
    }; 
     
    Map<String, Integer> map = new HashMap<>();
         
    map.put("A", 1);
    map.put("B", 2);
    map.put("C", 3);
     
    map.forEach(action);



## Use Java forEach() to iterate over a Stream of integers, find all the even numbers and print it through a consumer action (interface)

    List<Integer> numberList = Arrays.asList(1,2,3,4,5);
         
    Consumer<Integer> action = System.out::println;
     
    numberList.stream()
        .filter(n -> n%2  == 0)
        .forEach( action );



# 2.1. Stream.of()
## creating a stream of a fixed number of integers.

    public class StreamBuilders 
    {
         public static void main(String[] args)
         {
             Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9);
             stream.forEach(p -> System.out.println(p));
         }
    }

# 2.2. Stream.of(array)
## Creating a stream from the array. The elements in the stream are taken from the array.

    public class StreamBuilders 
    {
         public static void main(String[] args)
         {
             Stream<Integer> stream = Stream.of( new Integer[]{1,2,3,4,5,6,7,8,9} );
             stream.forEach(p -> System.out.println(p));
         }
    }

# 2.3. List.stream()
## Creating a stream from the List. The elements in the stream are taken from the List.

    public class StreamBuilders 
    {
         public static void main(String[] args)
         {
             List<Integer> list = new ArrayList<Integer>();
     
             for(int i = 1; i< 10; i++){
                 list.add(i);
             }
     
             Stream<Integer> stream = list.stream();
             stream.forEach(p -> System.out.println(p));
         }
    }



# 2.4. Stream.generate() or Stream.iterate()
## Creating a stream from generated elements. This will produce a stream of 20 random numbers. We have restricted the elements count using limit() function.

    public class StreamBuilders 
    {
         public static void main(String[] args)
         {
             Stream<Integer> randomNumbers = Stream
                 .generate(() -> (new Random()).nextInt(100));
     
             randomNumbers.limit(20)
                  .forEach(System.out::println);
         }
    }


# 2.5. Stream of String chars or tokens

## First, creating a stream from the characters of a given string. In the second part, we are creating the stream of tokens received from splitting from a string.

    public class StreamBuilders 
    {
         public static void main(String[] args)
         {
            IntStream stream = "12345_abcdefg".chars();
            stream.forEach(p -> System.out.println(p));
             
        //OR
             
            Stream<String> stream = Stream.of("A$B$C".split("\\$"));
            stream.forEach(p -> System.out.println(p));
         }



# 3. Stream Collectors

## After performing the intermediate operations on elements in the stream, we can collect the processed elements again into a Collection using the stream Collector methods.

# 3.1. Collect Stream elements to a List

## first, we are creating a stream on integers 1 to 10. Then we are processing the stream elements to find all even numbers. At last, we are collecting all even numbers into a List.

    public class StreamBuilders 
    {
         public static void main(String[] args)
         {
             List<Integer> list = new ArrayList<Integer>();
     
             for(int i = 1; i< 10; i++){
                 list.add(i);
             }
     
             Stream<Integer> stream = list.stream();
             List<Integer> evenNumbersList = stream.filter(i -> i%2 == 0)
                                                    .collect(Collectors.toList());
             System.out.print(evenNumbersList);
         }
    }


# 3.2. Collect Stream elements to an Array

## Write an code similar to the first example shown above. The only difference is that we are collecting the even numbers in an Array. There are plenty of other ways also to collect stream into a Set, Map or into multiple ways. Just go through Collectors class and try to keep them in mind.


    public class StreamBuilders 
    {
         public static void main(String[] args)
         {
             List<Integer> list = new ArrayList<Integer>();
     
             for(int i = 1; i< 10; i++){
                 list.add(i);
             }
     
             Stream<Integer> stream = list.stream();
             Integer[] evenNumbersArr = stream.filter(i -> i%2 == 0).toArray(Integer[]::new);
             System.out.print(evenNumbersArr);
         }
     }



# 4. Stream Operations
Stream abstraction has a long list of useful functions. Let us look at a few of them.

## build a List of strings beforehand. We will build our examples on this list so that it is easy to relate and understand.

    List<String> memberNames = new ArrayList<>();
    memberNames.add("Amitabh");
    memberNames.add("Shekhar");
    memberNames.add("Aman");
    memberNames.add("Rahul");
    memberNames.add("Shahrukh");
    memberNames.add("Salman");
    memberNames.add("Yana");
    memberNames.add("Lokesh");

These core methods have been divided into 2 parts given below:

# 4.1. Intermediate Operations
Intermediate operations return the stream itself so you can chain multiple methods calls in a row. Let’s learn important ones.

# 4.1.1. Stream.filter()

The filter() method accepts a Predicate to filter all elements of the stream. This operation is intermediate which enables us to call another stream operation (e.g. forEach()) on the result.

## Write an example that filters a list of strings starting with 'A' and prints them

    memberNames.stream().filter((s) -> s.startsWith("A"))
                        .forEach(System.out::println);


# 4.1.2. Stream.map()
The map() intermediate operation converts each element in the stream into another object via the given function.

## Write an example that converts each string into an UPPERCASE string. But we can use map() to transform an object into another type as well.

    memberNames.stream().filter((s) -> s.startsWith("A"))
                        .map(String::toUpperCase)
                        .forEach(System.out::println);                 

    Program Output:
    AMITABH
    AMAN

# 4.1.2. Stream.sorted()
The sorted() method is an intermediate operation that returns a sorted view of the stream. The elements in the stream are sorted in natural order unless we pass a custom Comparator.

## Given a list of strings, write an example that SORTS and then converts each string into an UPPERCASE string. But we can use map() to transform an object into another type as well.

    memberNames.stream().sorted()
                        .map(String::toUpperCase)
                        .forEach(System.out::println);

    Program Output:
    AMAN
    AMITABH
    LOKESH
    RAHUL
    SALMAN
    SHAHRUKH
    SHEKHAR
    YANA

    Please note that the sorted() method only creates a sorted view of the stream without manipulating the ordering of the source Collection. In this example, the ordering of string in the memberNames is untouched.

# 4.2. Terminal operations

Terminal operations return a result of a certain type after processing all the stream elements.

Once the terminal operation is invoked on a Stream, the iteration of the Stream and any of the chained streams will get started. Once the iteration is done, the result of the terminal operation is returned.

# 4.2.1. Stream.forEach()

The forEach() method helps in iterating over all elements of a stream and perform some operation on each of them. The operation to be performed is passed as the lambda expression.

## Given a list of strings, use foreach to

    memberNames.forEach(System.out::println);

# 4.2.2. Stream.collect()

    The collect() method is used to receive elements from a steam and store them in a collection.
    List<String> memNamesInUppercase = memberNames.stream().sorted()
                                .map(String::toUpperCase)
                                .collect(Collectors.toList());
         
    System.out.print(memNamesInUppercase);

    Program Output:
    [AMAN, AMITABH, LOKESH, RAHUL, SALMAN, SHAHRUKH, SHEKHAR, YANA]


#4.2.3. Stream.match()

Various matching operations can be used to check whether a given predicate matches the stream elements. All of these matching operations are terminal and return a boolean result.

    boolean matchedResult = memberNames.stream()
            .anyMatch((s) -> s.startsWith("A"));
     
    System.out.println(matchedResult);
     
    matchedResult = memberNames.stream()
            .allMatch((s) -> s.startsWith("A"));
     
    System.out.println(matchedResult);
     
    matchedResult = memberNames.stream()
            .noneMatch((s) -> s.startsWith("A"));
     
    System.out.println(matchedResult);

    Program Output:
    true
    false
    false
    4.2.4. Stream.count()


## The count() is a terminal operation returning the number of elements in the stream as a long value.

    long totalMatched = memberNames.stream()
        .filter((s) -> s.startsWith("A"))
        .count();
     
    System.out.println(totalMatched);

    Program Output:
    2


# 4.2.5. Stream.reduce()
The reduce() method performs a reduction on the elements of the stream with the given function. The result is an Optional holding the reduced value.

## In the given example, we are reducing all the strings by concatenating them using a separator #.

    Optional<String> reduced = memberNames.stream()
            .reduce((s1,s2) -> s1 + "#" + s2);
     
    reduced.ifPresent(System.out::println);

    Program Output:
    Amitabh#Shekhar#Aman#Rahul#Shahrukh#Salman#Yana#Lokesh

## Get the longest word in a list of words

    List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");

    // The result of the reduce() method is an Optional because the list on which reduce() is called may be empty.
    Optional<String> longestString = words.stream()
            .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);

    longestString.ifPresent(System.out::println);

## Combine all the string in a list of strings and print 

    Optional<String> String_combine = words.stream().reduce((str1, str2) -> str1 + "-" + str2);
    String_combine.ifPresent(System.out::println);

## Get the sum of all elements in a Integer Array

    List<Integer> array = Arrays.asList(-2, 0, 4, 6, 8);

    // Finding sum of all elements
    int sum = array.stream().reduce(0, (element1, element2) -> element1 + element2);
    System.out.println(sum);

## To get the product of all elements in given range excluding the rightmostelement

    int product = IntStream.range(2, 8).reduce((num1, num2) -> num1 * num2).orElse(-1);
    System.out.println(product);





# 5. Stream Short-circuit Operations

Though stream operations are performed on all elements inside a collection satisfying a Predicate, it is often desired to break the operation whenever a matching element is encountered during iteration.
In external iteration, we will do with the if-else block. In the internal iterations such as in streams, there are certain methods we can use for this purpose.



# 5.1. Stream.anyMatch()
The anyMatch() will return true once a condition passed as predicate satisfies. Once a matching value is found, no more elements will be processed in the stream.

## Find (true/fase) whether there is an element in a list of strings that starts with 'A'. Use anyMatch() method, as soon as a String is found starting with the letter 'A', the stream will end and the result will be returned.
    
    boolean matched = memberNames.stream()
            .anyMatch((s) -> s.startsWith("A"));
     
    System.out.println(matched);

    Program Output:
    true

# 5.2. Stream.findFirst()

## Print the first element in a list of string that starts with 'L'. The findFirst() method will return the first element from the stream and then it will not process any more elements.

    String firstMatchedName = memberNames.stream()
                .filter((s) -> s.startsWith("L"))
                .findFirst()
                .get();
     
    System.out.println(firstMatchedName);

    Program Output:
    Lokesh



# 6. Parallelism in Java Steam
To enable parallelism, all we have to do is to create a parallel stream, instead of a sequential stream. And to surprise, this is really very easy.

## In any of the above-listed stream examples, anytime we want to do a particular job using multiple threads in parallel cores, all we have to call parallelStream() method instead of stream() method.

    public class StreamBuilders 
    {
         public static void main(String[] args){
     
            List<Integer> list = new ArrayList<Integer>();
             for(int i = 1; i< 10; i++){
                 list.add(i);
             }
              
            //Here creating a parallel stream
             Stream<Integer> stream = list.parallelStream();  
     
             Integer[] evenNumbersArr = stream.filter(i -> i%2 == 0).toArray(Integer[]::new);
             System.out.print(evenNumbersArr);
         }}



# 7.1 Java Boxed Stream Example
A boxed stream is a stream of the wrapper class instances to simulate a stream of primitives.

    //It works perfectly!!
    List<String> strings = Stream.of("how", "to", "do", "in", "java")
                        .collect(Collectors.toList());

    However, the same process doesnt work on streams of primitives.
    //Compilation Error !!
    IntStream.of(1,2,3,4,5)
        .collect(Collectors.toList());

To convert a stream of primitives, we must first box the elements in their wrapper classes and then collect the wrapped objects in a collection. This type of stream is called boxed stream.


## Convert int stream to List of Integers.

    //Get the collection and later convert to stream to process elements
    List<Integer> ints = IntStream.of(1,2,3,4,5)
                    .boxed()
                    .collect(Collectors.toList());
             
    System.out.println(ints);
     
    //Stream operations directly
    Optional<Integer> max = IntStream.of(1,2,3,4,5)
                    .boxed()
                    .max(Integer::compareTo);
     
    System.out.println(max);


# convert double stream to List of Doubles.
    List<Double> doubles = DoubleStream.of(1d,2d,3d,4d,5d)
                .boxed()
                .collect(Collectors.toList());
         
    System.out.println(doubles);


# 1. Misc problem on Java Streams 
## Create a primitive int Array; convert it to list of Integer ; find all multiples of 3; return the as 

        Integer[] numbers = new Integer[] { 1, 2, 4, 5, 7, 8, 6 };
        int[] pnums = new int[] { 1, 2, 4, 5, 7, 8, 6 };
        Stream<Integer> s = Stream.of(numbers);
        s.forEach(p -> System.out.println(p));

## To a list of Integers 
        List<Integer> resultList = s.filter(x -> x ** 3 == 0).collect(Collectors.toList());
## To an Integer Array
        Integer[] arrayInteger = s.filter(x -> x % 3 == 0).toArray(Integer[]::new);
## To an int Array
        int[] arrayint = s.filter(x -> x % 3 == 0).mapToInt(Integer::new).toArray();


## Convert a List of Integers -> return list of Integers only even numbers
        List<Integer> lint = Arrays.asList(1, 2, 4, 5, 7, 8, 6);

# 2. Misc problem on Java Streams 

## Create a list of integers 
    List<Integer> number = Arrays.asList(2,3,4,5); 
  
## Return a list of squares of this Integer list using of map method 
    List<Integer> square = number.stream().map(x -> x*x). 
                           collect(Collectors.toList()); 
    System.out.println(square); 
  
## Create a list of Strings 
    List<String> names = 
                Arrays.asList("Reflection","Collection","Stream"); 
  
## Return a list of strings starting with 'S' using the filter method 
    List<String> result = names.stream().filter(s->s.startsWith("S")). 
                          collect(Collectors.toList()); 
    System.out.println(result); 
  
## Sort the list of string using sorted method  and print them.
    List<String> show = 
            names.stream().sorted().collect(Collectors.toList()); 
    System.out.println(show); 
  
## Convert a list of integers to set of square of Integers
    List<Integer> numbers = Arrays.asList(2,3,4,5,2); 

    // collect method returns a set 
    Set<Integer> squareSet = 
         numbers.stream().map(x->x*x).collect(Collectors.toSet()); 
    System.out.println(squareSet); 
  

## Print the squares of a list of Integers and print them forEach method 
    number.stream().map(x->x*x).forEach(y->System.out.println(y)); 


## Print the sum of all even numbers in a list of Integers using reduce method 
    int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i); 



## Ref:  https://howtodoinjava.com/java8/java-streams-by-examples/