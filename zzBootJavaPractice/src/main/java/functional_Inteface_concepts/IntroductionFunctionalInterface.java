/*

 *** JAVA FUNCTIONAL INTERFACES ***
 
	An Interface that contains exactly one abstract method is known as FUNCTIONAL INTERFACE. 
	
	It can have any number of DEFAULT, STATIC METHODS but can contain only one abstract method. 
	It can also declare methods of object class.
	
	FUNCTIONAL INTERFACE is also known as Single Abstract Method Interfaces or SAM Interfaces. 
	It is a new feature in Java, which helps to achieve functional programming approach.

	
	A functional interface can have methods of object class.
	
  EXAMPLE 1 :-
  
 */
package functional_Inteface_concepts;

/**
 * @author Sameer Kadgaye
 *
 */
@FunctionalInterface
interface sayable {

	void say(String msg);

// default int add(int a, int b); C.E : Need Body for Default & static method.
// static String myMessege(String msg); C.E : Need Body for Default & static method.

	default int add(int a, int b) {
		return a * b;
	}

	static String myMessege(String msg) {
		return msg;
	}

	// int getNumber(); C.E :- Not Functional Interface because Functional Interface Contains
	// only one Abstract method and many default & static method.
}

public class IntroductionFunctionalInterface implements sayable{

	@Override
	public void say(String msg) {
		System.out.println(msg);
	}
	public static void main(String[] args) {
		IntroductionFunctionalInterface functionalInterface= new IntroductionFunctionalInterface();
		functionalInterface.say("I am Executed With Functional Interface Concept.");
	}

}
