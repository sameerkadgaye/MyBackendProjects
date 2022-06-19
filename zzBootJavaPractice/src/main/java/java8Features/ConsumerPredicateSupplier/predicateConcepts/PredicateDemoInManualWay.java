/**
 * 
 */
package java8Features.ConsumerPredicateSupplier.predicateConcepts;

import java.util.function.Predicate;

/**
 * @author SAMEER.KADGAYE
 *
 */														//Instead of Integer Any Class As Generic
public class PredicateDemoInManualWay implements Predicate<Integer> {
	//Predicate Ha Functional interface ahe jo Apan Used Karto conditions check aplya kontya pan statement sathi. Yat test(T) method
	//hi used hote with genric Datatype(Dynamically given i.e T). 
	
	@Override
	public boolean test(Integer t) {
		if (t % 2 == 0) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		PredicateDemoInManualWay predicate = new PredicateDemoInManualWay();
		System.out.println("Value is true means Even And False means Odd : "+predicate.test(4));
		
		
		//OR With Lamda some Simplified
		
		Predicate<Integer> testThePredicate =(t)-> {
			if (t % 2 == 0) {
				return true;
			}else {
				return false;
			}
		};
		System.out.println("With Lamda Value is true means Even And False means Odd : "+testThePredicate.test(8));
		
		
		//OR With Lamda Very Simplified 
		Predicate<Integer> testThePredicateMoreSimplified =t-> t % 2 == 0;
		System.out.println("With Lamda Very Simplified Value is true means Even And False means Odd : "+testThePredicateMoreSimplified.test(8));
		
	}

}
