/*
 
 INVALID FUNCTIONAL INTERFACE :
	
	A functional interface can extends another interface only when it does not have any abstract method.
 
*/
package functional_Inteface_concepts;

/**
 * @author Sameer Kadgaye
 *
 */
interface sayable3 {
	void say(String msg);
}

@FunctionalInterface
interface useInterfaceInheristanceConcept extends sayable3 {
	// void say1(); //C.E : Invalid '@FunctionalInterface' annotation;
	// useInterfaceInheristanceConcept is not a functional interface
}

public class InvalidFunctionalInterfaceConcept {

	public static void main(String[] args) {

	}

}
