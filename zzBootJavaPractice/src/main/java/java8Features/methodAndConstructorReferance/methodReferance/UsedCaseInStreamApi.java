/**
 * 
 */
package java8Features.methodAndConstructorReferance.methodReferance;

import java.util.Arrays;
import java.util.List;

/**
 * @author SAMEER KADGAYE
 *
 */
public class UsedCaseInStreamApi {

	public static void main(String[] args) {
		List<Integer> number = Arrays.asList(2, 5, 6, 8);
		number.forEach(System.out::println);
					  //PrintStream java.lang.System.out Class Object Refer println method.
	}
}
