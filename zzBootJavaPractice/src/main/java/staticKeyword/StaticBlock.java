/**
 * 
 */
package staticKeyword;

/**
 * @author sameer
 *
 */
class StaticBlockDemo {

	int c = 30;

	static int result;
	static {
		System.out.println(
				"Jevha apla static block ha non implemented main method class madhe asel tar aplya la externally dusrya class madhe ya class cha just fact Object [ Class obj= new Class(); ] Banava lagel Tya mude ha perticular class ha tya dusrya class madhe load hoil\n\n");

		System.out.println(
				"It is special Block for Intialized / Declare (For declare scope within static block only) Static Variables Succesful");
		int a = 10;
		int b = 10;
		result = a + b;
		System.out.println("\nResult is  ====>>>" + result);
		// c=40; // compile time error // non static not allow in static block.

	}

}

public class StaticBlock {

	/**
	 * @param args
	 */
	static {
		System.out.println(
				"Jo Main Mehod Wala class asel tith ha block automatically laod haun jail main method through\n");

	}

	public static void main(String[] args) {

		StaticBlockDemo demo = new StaticBlockDemo();

	}

}
