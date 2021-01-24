package com.tow.core.CSV;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

// REFS: 
// https://www.geeksforgeeks.org/mapping-csv-to-javabeans-using-opencsv/
// https://www.journaldev.com/12014/opencsv-csvreader-csvwriter-example

public class csvFiletoObject {

	@Test
	public void CSVtoBeanConverter() {
//		public static void main(String[] args) {

		// Hashmap to map CSV data to
		// Bean attributes.
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("name", "Name");
		mapping.put("rollno", "RollNo");
		mapping.put("department", "Department");
		mapping.put("result", "Result");
		mapping.put("cgpa", "Pointer");

		// HeaderColumnNameTranslateMappingStrategy
		// for Student class
		HeaderColumnNameTranslateMappingStrategy<Student> strategy = new HeaderColumnNameTranslateMappingStrategy<Student>();
		strategy.setType(Student.class);
		strategy.setColumnMapping(mapping);

		// Create castobaen and csvreader object
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader(
					"H:\\WorkSpace_Eclipse3\\Java-Quick-Start\\src\\main\\java\\com\\tow\\core\\CSV\\StudentData.csv"));
		} catch (FileNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CsvToBean csvToBean = new CsvToBean();

		// call the parse method of CsvToBean
		// pass strategy, csvReader to parse method
		List<Student> list = csvToBean.parse(strategy, csvReader);

		// print details of Bean object
		for (Student e : list) {
			System.out.println(e);
		}
	}

	public List<Student> CSVtoStudentObject() {

		// Hashmap to map CSV data to
		// Bean attributes.
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("name", "Name");
		mapping.put("rollno", "RollNo");
		mapping.put("department", "Department");
		mapping.put("result", "Result");
		mapping.put("cgpa", "Pointer");

		// HeaderColumnNameTranslateMappingStrategy
		// for Student class
		HeaderColumnNameTranslateMappingStrategy<Student> strategy = new HeaderColumnNameTranslateMappingStrategy<Student>();
		strategy.setType(Student.class);
		strategy.setColumnMapping(mapping);

		// Create castobaen and csvreader object
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader(
					"H:\\WorkSpace_Eclipse3\\Java-Quick-Start\\src\\main\\java\\com\\tow\\core\\CSV\\StudentData.csv"));
		} catch (FileNotFoundException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CsvToBean csvToBean = new CsvToBean();

		// call the parse method of CsvToBean
		// pass strategy, csvReader to parse method
		List<Student> list = csvToBean.parse(strategy, csvReader);

		// print details of Bean object
		for (Student e : list) {
			System.out.println(e);
		}
		return list;
	}

	@Test
	public void CSVtoCountryConverter() throws IOException {

		String fileName = "H:\\WorkSpace_Eclipse3\\Java-Quick-Start\\src\\main\\java\\com\\tow\\core\\CSV\\Country.csv";

		List<Country> beans = new CsvToBeanBuilder(new FileReader(fileName)).withType(Country.class).build().parse();

		beans.forEach(System.out::println);

	}

	public List<Country> CSVtoCountryObject() throws IOException {

		String fileName = "H:\\WorkSpace_Eclipse3\\Java-Quick-Start\\src\\main\\java\\com\\tow\\core\\CSV\\Country.csv";

		List<Country> beans = new CsvToBeanBuilder(new FileReader(fileName)).withType(Country.class).build().parse();

		beans.forEach(System.out::println);

		return beans;

	}
}
