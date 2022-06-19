/**
 * 
 */
package functional_Inteface_concepts;

/**
 * @author SAMEER KADGAYE
 *
 */
interface sayable4 {
	default int add(int a, int b) {
		return a * b;
	}

	static String myMessege(String msg) {
		return msg;
	}

	// It can contain any number of Object class methods.
	int hashCode();

	String toString();

	boolean equals(Object obj);
}

@FunctionalInterface
interface useInterfaceInheristanceConcept1 extends sayable4 {
	void any(String msg);
}

public class ValidFunctionalInterfaceConcept implements useInterfaceInheristanceConcept {

	@Override
	public void say(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		ValidFunctionalInterfaceConcept concept = new ValidFunctionalInterfaceConcept();
		concept.say("Success");

	}

}
