package com.tow.core.Streams;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

// Ref :: [BEST] https://stackify.com/streams-guide-java-8/
// https://github.com/Baeldung/stackify/tree/master/core-java/src/test/java/com/stackify/stream

public class stream_with_objects2 {
	private static Employee[] arrayOfEmps = { // generate list
			new Employee(1, "Jeff Bezos", 100000.0), new Employee(2, "Bill Gates", 200000.0),
			new Employee(3, "Mark Zuckerberg", 300000.0), new Employee(4, "Elon Musk", 900000.0),
			new Employee(5, "Rick Churn", 500000.0) };

	private static List<Employee> empList = Arrays.asList(arrayOfEmps);
	private static EmployeeRepository employeeRepository = new EmployeeRepository(empList);

	// Advanced
	private static Department[] arrayOfDeps = { // generate list
			new Department(1, "sales"), new Department(4, "marketing"), new Department(5, "sales") };

	private static List<Department> deptList = Arrays.asList(arrayOfDeps);

	@Test
	public void streamTest() {

		// First check if the List is okay
		empList.forEach(System.out::println);

		// initialize Stream # 2 ways
		Stream.of(arrayOfEmps); // method 1
		System.out.println();
		empList.stream().forEach(System.out::println); // method 2 & also pring with toString() override
	}

	@Test
	public void whenIncrementSalaryForEachEmployee_thenApplyNewSalary() {
		empList.stream().forEach(e -> e.salaryIncrement(10.0));
		empList.stream().parallel().forEach(e -> e.salaryIncrement(10.0)); // to run in parallel
		System.out.println(empList);

//		assertThat(empList, contains(hasProperty("salary", equalTo(110000.0)), hasProperty("salary", equalTo(220000.0)),
//				hasProperty("salary", equalTo(330000.0))));
	}

//	@Test
	public void whenMapIdToEmployees_thenGetEmployeeStream() {
		Integer[] empIds = { 1, 2, 3 };

		List<Employee> employees = Stream.of(empIds).map(employeeRepository::findById).collect(Collectors.toList());
		System.out.println(employees);
		assertEquals(employees.size(), empIds.length);
	}

//	@Test
	public void whenCollectStreamToList_thenGetList() {
		List<Employee> employees = empList.stream().collect(Collectors.toList());
		System.out.println(employees);

		assertEquals(empList, employees);
	}

//	@Test
	public void whenFilterEmployees_thenGetFilteredStream() {
		Integer[] empIds = { 2, 3, 4 };

		List<Employee> employees = Stream.of(empIds).map(employeeRepository::findById).filter(e -> e != null)
				.filter(e -> e.getSalary() > 200000).collect(Collectors.toList());
		System.out.println(employees);

		assertEquals(Arrays.asList(arrayOfEmps[2]), employees);
	}

//	@Test
	@SuppressWarnings("deprecation")
	public void whenStreamToArray_thenGetArray() {
		Employee[] employees = empList.stream().toArray(Employee[]::new);
		System.out.println(employees);
		assertEquals(empList.toArray(), employees);
	}

//	@Test
	// A stream can hold complex data structures like Stream<List<String>>. In cases
	// like this, flatMap() helps us to flatten the data structure to simplify
	// further operations:

	public void whenFlatMapEmployeeNames_thenGetNameStream() {
		List<List<String>> namesNested = Arrays.asList(Arrays.asList("Jeff", "Bezos"), Arrays.asList("Bill", "Gates"),
				Arrays.asList("Mark", "Zuckerberg"));

		List<String> namesFlatStream = namesNested.stream().flatMap(Collection::stream).collect(Collectors.toList());

		assertEquals(namesFlatStream.size(), namesNested.size() * 2);
	}

//	@Test
	// peek() can be useful in situations it performs the specified operation on
	// each element of the stream and returns a new stream which can be used
	// further. peek() is an intermediate operation:

	public void whenIncrementSalaryUsingPeek_thenApplyNewSalary() {
		empList.stream().peek(e -> e.salaryIncrement(10.0)).peek(System.out::println).collect(Collectors.toList());
	}

	// Intermediate operations such as filter() return a new stream on which further
	// processing can be done. Terminal operations, such as forEach(), mark the
	// stream as consumed, after which point it can no longer be used further. A
	// stream pipeline consists of a stream source, followed by zero or more
	// intermediate operations, and a terminal operation.
//	@Test
	public void whenStreamCount_thenGetElementCount() {
		Long empCount = empList.stream().filter(e -> e.getSalary() > 200000).count();

		assertEquals(empCount, new Long(1));
	}

//	@Test
	public void whenLimitInfiniteStream_thenGetFiniteElements() {
		Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2); // this will generate an infinite stream

		List<Integer> collect = infiniteStream.skip(3).limit(5).collect(Collectors.toList()); // limit imposes bounds
		System.out.println(collect);

		assertEquals(collect, Arrays.asList(16, 32, 64, 128, 256));
	}

	// All intermediate operations are lazy, so they’re not executed until a result
	// of a processing is actually needed. For example, consider the findFirst()
	// example we saw earlier. How many times is the map() operation performed here?
	// 4 times, since the input array contains 4 elements?
//	@Test
	public void whenFindFirst_thenGetFirstEmployeeInStream() {
		Integer[] empIds = { 1, 2, 3, 4 };

		Employee employee = Stream.of(empIds).map(employeeRepository::findById).filter(e -> e != null)
				.filter(e -> e.getSalary() > 100000).findFirst().orElse(null);
		System.out.println(employee);

		assertEquals(employee.getSalary(), new Double(200000));
	}

//	@Test
	// we can sort Employees based on their names:
	public void whenSortStream_thenGetSortedStream() {
		List<Employee> employees = empList.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
				.collect(Collectors.toList());
		System.out.println(employees);
		assertEquals(employees.get(0).getName(), "Bill Gates");
		assertEquals(employees.get(1).getName(), "Elon Musk");
		assertEquals(employees.get(2).getName(), "Jeff Bezos");

	}

//	@Test
	// Get Employee with Max salary
	public void whenFindMax_thenGetMaxElementFromStream() {

		// method 1: using max()
		Employee maxSalEmp = empList.stream().max(Comparator.comparing(Employee::getSalary))
				.orElseThrow(NoSuchElementException::new);
		System.out.println("Max Salary for " + maxSalEmp);

		// Method 2: using reduce
		Employee maxSalEmp0 = empList.stream().reduce((a, b) -> a.getSalary() > b.getSalary() ? a : b)
				.orElseThrow(NoSuchElementException::new);
		System.out.println("Max Salary for " + maxSalEmp0);
		assertEquals(maxSalEmp.getSalary(), new Double(900000.0));
	}

//	@Test
	// Get Employee min ID
	public void whenFindMin_thenGetMinElementFromStream() {

		// Method 1
		Employee firstEmp = empList.stream().min((e1, e2) -> e1.getId() - e2.getId())
				.orElseThrow(NoSuchElementException::new);
		System.out.println("Min ID for " + firstEmp);

		// Method 2
		firstEmp = empList.stream().min(Comparator.comparing(Employee::getId)).orElseThrow(NoSuchElementException::new);
		System.out.println("Min ID for " + firstEmp);

		// Method 3 : reduce
		firstEmp = empList.stream().reduce((a, b) -> a.getId() > b.getId() ? a : b)
				.orElseThrow(NoSuchElementException::new);
		System.out.println("Min ID for " + firstEmp);

		assertEquals(firstEmp.getId(), new Integer(1));
	}

	@Test
	// Max ID value
	public void whenFindMaxOnIntStream_thenGetMaxInteger() {
		Integer latestEmpId = empList.stream().mapToInt(Employee::getId).max().orElseThrow(NoSuchElementException::new);
		System.out.println("Max ID :: " + latestEmpId);
		assertEquals(latestEmpId, new Integer(5));
	}

//	@Test
	// Average salary and others sum(), average(), range() etc:
	public void whenApplySumOnIntStream_thenGetSum() {
		Double avgSal = empList.stream().mapToDouble(Employee::getSalary).average()
				.orElseThrow(NoSuchElementException::new);
		System.out.println("Average of all salaries:: " + avgSal);
		assertEquals(avgSal, new Double(400000));
	}

//	@Test
	// Sum of all salaries
	public void whenApplyReduceOnStream_thenGetValue() {

		// method 1
		Double sumSal = empList.stream().map(Employee::getSalary).reduce(0.0, Double::sum);
		System.out.println("Sum Salary:: " + sumSal);

		// method 2
		sumSal = empList.stream().mapToDouble(Employee::getSalary).average().orElseThrow(NoSuchElementException::new);

		System.out.println("Sum Salary:: " + sumSal);
		assertEquals(sumSal, new Double(2000000));
	}

//	@Test
	// stats over a dataset
	public void whenApplySummarizing_thenGetBasicStats() {

		// Method 1
		DoubleSummaryStatistics stats = empList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println(stats);

		// Method 2
		DoubleSummaryStatistics stats2 = empList.stream().mapToDouble(Employee::getSalary).summaryStatistics();
		System.out.println(stats2);
	}

//	@Test
	public void whenCollectByJoining_thenGetJoinedString() {
		String empNames = empList.stream().map(Employee::getName).collect(Collectors.joining(", ")).toString();

		System.out.println(empNames);
		assertEquals(empNames, "Jeff Bezos, Bill Gates, Mark Zuckerberg, Elon Musk, Rick Churn");
	}

//	@Test
	// Let’s split our List of numerical data, into even and odds: =>
	// Collectors.partitioningBy
	public void whenStreamPartition_thenGetMap() {
		List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
		Map<Boolean, List<Integer>> isEven = intList.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));

		assertEquals(isEven.get(true).size(), 4);
		assertEquals(isEven.get(false).size(), 1);
	}

//	@Test
	// where we can partition the stream into more than just two groups. =>
	// Collectors.groupingBy
	public void whenStreamGroupingBy_thenGetMap() {
		Map<Character, List<Employee>> groupByAlphabet = empList.stream()
				.collect(Collectors.groupingBy(e -> new Character(e.getName().charAt(0))));

		assertEquals(groupByAlphabet.get('B').get(0).getName(), "Bill Gates");
		assertEquals(groupByAlphabet.get('J').get(0).getName(), "Jeff Bezos");
		assertEquals(groupByAlphabet.get('M').get(0).getName(), "Mark Zuckerberg");
	}

	@Test
	// we can use mapping() which can actually adapt the collector to a different
	// type – using a mapping function: Collectors.mapping
	public void whenStreamMapping_thenGetMap() {
		Map<Character, List<Integer>> idGroupedByAlphabet = empList.stream().collect(Collectors.groupingBy(
				e -> new Character(e.getName().charAt(0)), Collectors.mapping(Employee::getId, Collectors.toList())));

		System.out.println(idGroupedByAlphabet);
		assertEquals(idGroupedByAlphabet.get('B').get(0), new Integer(2));
		assertEquals(idGroupedByAlphabet.get('J').get(0), new Integer(1));
		assertEquals(idGroupedByAlphabet.get('M').get(0), new Integer(3));
	}

	/*
	 ******************************************************************************************************************
	 * matching and searching through 2 different list (collections) using streams
	 ******************************************************************************************************************/
//	@Test
	public void givenDepartmentList_thenEmployeeListIsFilteredCorrectly() {
		Integer expectedId = 1; // Jeff Bezos

		List<Employee> filteredList = empList.stream()
				.filter(empl -> deptList.stream().anyMatch(
						dept -> dept.getDepartment().equals("sales") && empl.getId().equals(dept.getEmployeeId())))
				.collect(Collectors.toList());

		System.out.println(filteredList);

		assertEquals(expectedId, filteredList.get(0).getId());
	}

}

/*
 * THIS IS THE EMPLOYEE CLASS and THE EMPLOYEEREPOSITORY CLASS containing the
 * data and static functions of the employee objects.
 */
class Employee {
	String name;
	Integer id;
	Double salary;

	public Employee(Integer id, String name, Double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public void salaryIncrement(Double percentage) {
		Double newSalary = salary + percentage * salary / 100;
		setSalary(newSalary);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emp{id=").append(id).append(", name=").append(name).append(", salary=").append(salary)
				.append("}");

		return builder.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}

class EmployeeRepository {
	private List<Employee> empList;

	public EmployeeRepository(List<Employee> empList) {
		this.empList = empList;

	}

	public Employee findById(Integer id) {
		for (Employee emp : empList) {
			if (emp.getId() == id) {
				return emp;
			}
		}

		return null;
	}
}

class Department {
	Integer employeeId;
	String department;

	public Department(Integer employeeId, String department) {
		this.employeeId = employeeId;
		this.department = department;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}