/**
 * 
 */
package finalAndStaticTickyQuestions.staticConcepts;

/**
 * @author Sameer Kadgaye
 *
 */
public class CheckStaticMethodIsOverloadOrNot {

	// Yes It is possible to overload static method

	public static void main(String[] args) {

	}

	static void myStaticMethod(int a) {
		System.out.println("My Static ====>>> ");
	}

	static void myStaticMethod(int a, int b) {
		System.out.println("My Static ====>>> ");
	}

}
