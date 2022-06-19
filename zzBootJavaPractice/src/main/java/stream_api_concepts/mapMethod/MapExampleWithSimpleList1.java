/**
 * 
 */
package stream_api_concepts.mapMethod;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sameer.kadgaye
 *
 */
public class MapExampleWithSimpleList1 {

	private static void exmaple1() {
		System.out.println("The stream after applying " + "the function is : ");

		// Creating a list of Integers
		List<Integer> list = Arrays.asList(3, 6, 9, 12, 15);

		// Using Stream map(Function mapper) and
		// displaying the corresponding new stream
		list.stream().map(number -> number * 3).forEach(System.out::println);
	}

	private static void exmaple2() {
		System.out.println("\nThe stream after applying " + "the function is : ");

		// Creating a list of Integers
		List<String> list = Arrays.asList("geeks", "gfg", "g", "e", "e", "k", "s");

		// Using Stream map(Function mapper) to
		// convert the Strings in stream to
		// UpperCase form
		List<String> answer = list.stream().map(String::toUpperCase).collect(Collectors.toList());

		// displaying the new stream of UpperCase Strings
		System.out.println("answer ==>> "+answer+"\n");

	}

	private static void exmaple3() {
		List<Employee>employeesList = Arrays.asList(new Employee(1,  "sameer", 100), new Employee(2,  "sanket", 100), new Employee(3,  "palash", 200));
		
		List<Integer> distinctSalaries = employeesList.stream().map(e -> e.getSalary()).distinct().collect(Collectors.toList());
		long salariesCount = employeesList.stream().map(e -> e.getSalary()).count();

		System.out.println("distinctSalaries ==>> "+distinctSalaries);
		System.out.println("salariesCount ==>> "+salariesCount);

	}

	public static void main(String[] args) {
		exmaple1();
		exmaple2();
		exmaple3();
	}

}
