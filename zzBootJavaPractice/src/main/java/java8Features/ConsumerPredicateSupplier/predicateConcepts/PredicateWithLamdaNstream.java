/**
 * 
 */
package java8Features.ConsumerPredicateSupplier.predicateConcepts;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author SAMEER KADGAYE
 *
 */
public class PredicateWithLamdaNstream {

	
	public static void main(String[] args) {
		Predicate<Integer> testThePredicate =t-> t % 2 == 0;
		System.out.println("With Lamda very simplified Value is true means Even And False means Odd : "+testThePredicate.test(8));
		
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		list1.stream().filter(testThePredicate).forEach(l ->System.out.println("Even Number : "+l));
		
		//OR Directly We give predicate into filter method.
		System.out.println("\n");
		list1.stream().filter(t ->  t % 2 == 0).forEach(l ->System.out.println("Direct Filter Even Number : "+l));
	}

}
