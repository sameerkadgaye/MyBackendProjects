/**
 * 
 */
package java8Features.optionalClass;

import java.util.Optional;

/**
 * @author SAMEER KADGAYE
 *
 */
public class OptionalClassConcept {
//	Optional Class is not serialize so tyala apan fact return Type manun used karna he changla ahe for null check condtions of Object.

	public static void startingIntroduction() {
		System.out.println("<<<<<<<================== Optional Class Introduction Started ==================>>>>>>>");
		//------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
		
		//•		int a =null;  // Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
				             //Type mismatch: cannot convert from null to Duplicate local variable a.
				
		//•		Que : Why primitive data types is not null in java  ?
		//•		Answer =======> Because it is a primitive type and not an object. You can use the corresponding object for each type if you need the ability to use null values.
							

		//•		Que : 	Why primitives are not a objects ?
		//		Answer ==> B'coz primitives are keywords in java so they own special meaning and functionality In Java. 
		//			       Ani objects tech astatat jynacha Class kiva Interface Availble Aste Java Madhe.
		//------------------------------------------------------------------------------------------------------------------------------------------------------------------------//

				
		//--------------------------------------------------------   For Value Not Present In Datatype Starts    ------------------------------------------------------------//
				String a1 = null;
				Optional<String> optional1 = Optional.ofNullable(a1); // Checks  Optional is Nullable or not it return true or false.
				System.out.println("Value Is Present : "+optional1.isPresent());  //isPresent() hi Method used hote value Optional Madhe Available ahe ki nahi tya sathi. Asel Tar Return True Or Return False.
				System.out.println("If Value Is Not Present : "+optional1.orElse("No Value Present in a1."));
				
		//		String a2 = "I am Present";
				String a2 = null; //I am Not Present;
				Optional<String> optional2 = Optional.ofNullable(a2); // Checks  Optional is Nullable or not it return true or false.
				System.out.println("Value Is Present : "+optional2.isPresent());  //isPresent() hi Method used hote value Optional Madhe Available ahe ki nahi tya sathi. Asel Tar Return True Or Return False.
				
				System.out.println("If Value Is Not Present : "+optional2.orElseGet(()-> "Hey"));
		//		System.out.println("If Value Is Not Present : "+optional2.orElseGet(()-> new String("Hey")));
		//		System.out.println("Get Value : "+optional2.get());
			

		//--------------------------------------------------------   For Value Not Present In Datatype Ends    -------------------------------------------------------------//
				
		//--------------------------------------------------------  For Value is Present In Datatype Starts  --------------------------------------------------------------//
				String a3 = "I am Present";
				Optional<String> optional3 = Optional.ofNullable(a3); // Checks  Optional is Nullable or not it return true or false.
				System.out.println("Value Is Present : "+optional3.isPresent());  //isPresent() hi Method used hote value Optional Madhe Available ahe ki nahi tya sathi. Asel Tar Return True Or Return False.
				
				System.out.println("If Value Is Present : "+optional3.get());
				System.out.println("If Value Is Present : "+optional3.orElseGet(()-> "Hey")); //OrElseGet Not Valid AnyMore if value is available.

		//--------------------------------------------------------   For Value is Present In Datatype Ends    -------------------------------------------------------------//
		System.out.println("<<<<<<<================== Optional Class Introduction Ended ==================>>>>>>>\n");
	}
	
	private static void methodOfOptionalClass() throws Exception {
		System.out.println("<<<<<<<================== Optional Class Methods Started ==================>>>>>>>");
		//•	1) empty()
		//•	2) of()
		//•	3) ofNullable()
		//•	4) get()
		//•	5) isPresent()
		//•	6) orElse()
		//•	7) orElseGet()
		//•	7) orElseThrow()
		
		
		//1) empty() Method :
		Optional<Object> emptyOptional = Optional.empty();  //empty() method hi create karte empty Optional Class la.
															// internally hi method new Keyword OptionalClass chya constructor Object cha implementation provide karte.
															// i.e : private static final Optional<?> EMPTY = new Optional<>(null); //Please see in Java Docs.
		
		//2) of() Method :
		String isNotNullString = "I am Not Null String";
		Optional<String> of = Optional.of(isNotNullString);  //Jevha Apan Purnpane Clear ahot of() method chya arguments madhe pass keleli value hi not null ahe.
															 // Tevha Apan of() method used karto.
		System.out.println("of Output without get : "+of);
		System.out.println("of Output with get : "+of.get());
		System.out.println("of Output with or Else : "+of.orElse("Muze Pata Hai Mai Null Nahi rahne wala")+"\n");
		
		
		//3) of() Method :
		String isNotNull_Or_May_Be_Null_String = "I am Not Sure ki I am Null Or May Be Not Null String";
		//isNotNull_Or_May_Be_Null_String = null;
		Optional<String> ofNullOptional = Optional.ofNullable(isNotNull_Or_May_Be_Null_String);  //Jevha Apan Purnpane Clear ahot of() method chya arguments madhe pass keleli value hi not null ahe.
																								// Tevha Apan of() method used karto.
		
		System.out.println("ofNullOptional Output without get : "+ofNullOptional); //comment this line if u uncomment //isNotNull_Or_May_Be_Null_String = null; comment.
		System.out.println("ofNullOptional Output with get : "+ofNullOptional.get()); //comment this line if u uncomment //isNotNull_Or_May_Be_Null_String = null; comment.
		System.out.println("ofNullOptional Output with or Else : "+ofNullOptional.orElse("I know now i was null")+"\n");
		//System.out.println("ofNullOptional Output with or Else : "+ofNullOptional.orElseThrow(()-> new Exception("Nahi Ahe Record Mazya kade"))); //comment this line if u uncomment //isNotNull_Or_May_Be_Null_String = null; comment.
		System.out.println("<<<<<<<================== Optional Class Methods Ended ==================>>>>>>>\n");
	}
	
	public static void main(String[] args) throws Exception {	
		startingIntroduction();
		methodOfOptionalClass();
	}
}
