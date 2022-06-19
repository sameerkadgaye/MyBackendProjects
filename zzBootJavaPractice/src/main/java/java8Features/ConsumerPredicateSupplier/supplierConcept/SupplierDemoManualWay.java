/**
 * 
 */
package java8Features.ConsumerPredicateSupplier.supplierConcept;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author SAMEER KADGAYE
 *
 */													//Instead of Integer Any Class As Generic
public class SupplierDemoManualWay implements Supplier<String>{

	@Override
	public String get() {
		return "My Name Is Sameer\n";
	}
	
	public static void main(String[] args) {
		SupplierDemoManualWay supplierDemoManualWay = new SupplierDemoManualWay();
		System.out.println(supplierDemoManualWay.get());
		
		
		//OR (With Anonymous Class Way)
		Supplier<String> sup = new Supplier<String>() {
			@Override
			public String get() {
				return "My Name Is Sameer with Anonymous class \n";
			}
		};
		System.out.println(sup.get());
		
		
		//OR With Lamda some Simplified
		
		Supplier<String> suPLamdbaSomeSimplified = () -> { return "I am Some Simplified Lambda \n"; };
		System.out.println(suPLamdbaSomeSimplified.get());
		
		//OR With Lamda Very Simplified 
		Supplier<String> supLamdbaMoreSimplified = () -> "I am More Simplified Lambda";
		System.out.println(supLamdbaMoreSimplified.get());
		
		//Example With Java Stream.
//		List<String> list1 = Arrays.asList("a", "b");
		List<String> list1 = Arrays.asList();
		System.out.println(list1.stream().findAny().orElseGet(() -> "Hi viewers"));
															//Supplier starts from orElseGet();
	}
}
