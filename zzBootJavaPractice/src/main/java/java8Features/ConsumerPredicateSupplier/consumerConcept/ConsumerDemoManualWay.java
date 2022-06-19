/**
 * 
 */
package java8Features.ConsumerPredicateSupplier.consumerConcept;

import java.util.function.Consumer;

/**
 * @author SAMEER KADGAYE
 *
 */													//Instead of String Any Class As Generic 
public class ConsumerDemoManualWay implements Consumer<String> {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ConsumerDemoManualWay oldWay = new ConsumerDemoManualWay();
		oldWay.accept("Sameer");

		// OR
		Consumer<String> anonymousWay = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println("Printing My Name With Anonymous Way Consumer : " + t);
			}
		};
		anonymousWay.accept("Anonymous");
		
		// OR
		Consumer<String> consumer1 = (t) -> {
			System.out.println("Printing My Name With Lamda Consumer : " + t);
		}; // WithOut Lamda
		consumer1.accept("sameer");
		
		// OR
		
		Consumer<Integer> consumer2 = t -> System.out.println("Printing Value With Shortcut Lamda In Old Way : " + t); // With Shortcuts Lamda
		consumer2.accept(10);
	}

	@Override
	public void accept(String t) {
		System.out.println("This How My Name Print With Consumer : " + t);
	}

}
