/**
 * 
 */
package java8Features.ConsumerPredicateSupplier.consumerConcept;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author sameer.kadgaye
 *
 */
public class ConsumerDemo {
	
	public static void startingIntroduction() {
		System.out.println("<<<<<<<================== Consumer Functional Interface Introduction Started ==================>>>>>>>");
		
		//Example 1 :
		
		Consumer<Integer> consumer1 = t -> System.out.println("I am In Accept() Implementation Printing The value : " + t); //With Lamda Manual Way
		consumer1.accept(10);

		//Example 2 :
		//void java.util.stream.Stream.forEach(Consumer<? super Integer> action)
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		list1.forEach(e->{}); //with out stream also Consumer available in forEach;
		list1.stream().forEach(consumer1); //It means ki apan Direct Ethe Consumer cha implention provide kelo forEach madhe.
		System.out.println("\n");
		
		//OR
		
		//Example 3 : 
		List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
		
		list2.stream().forEach(t -> System.out.println("print  : " + t));  //This Is How Apan Used karto forEach Sobat Lamda Expression. 
							//Ya madhe t ya consumer class ahe ani -> nantre chi step sysout wali hi accept method cha implemetation ahe.
		System.out.println("<<<<<<<================== Consumer Functional Interface  Introduction Started ==================>>>>>>>");
	}

	public static void main(String[] args) {
		startingIntroduction();
	}

}


