/**
 * 
 */
package java8Features.ConsumerPredicateSupplier.supplierConcept;

import java.util.function.Supplier;

/**
 * @author SAMEER KADGAYE
 *
 */
public class SupplierWithManualWayWithAnonymousClass {
	public static void main(String[] args) {
		Supplier<String> sup = new Supplier<String>() {
			@Override
			public String get() {
				return "My Name Is Sameer";
			}
		};
		System.out.println(sup.get());
	}

}
