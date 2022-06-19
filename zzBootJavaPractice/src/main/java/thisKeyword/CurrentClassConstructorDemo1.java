/**
 * 
 */
package thisKeyword;

/**
 * @author sameer
 *
 */
class ThisConstructorDemoClass {
	ThisConstructorDemoClass() {
		System.out.println("Its magic of this() ==>> This ParameterLess Constructor Accessed Succesfully.\n");
		// we can call this(--) keyword any of the constructor with parameter or
		// without-parameter.
	}

	ThisConstructorDemoClass(String x) {
		this();
		System.out.println(x);
	}
}

public class CurrentClassConstructorDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ThisConstructorDemoClass thisConstructorDemoClass = new ThisConstructorDemoClass(
				"I called This Parameterized Constructor.");

	}

}
