/**
 * 
 */
package exceptionHandling;

import java.util.Scanner;

/**
 * @author sameer
 *
 */
public class MutlipleCatchBlock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i;
		Scanner scanner = new Scanner(System.in);
		try {
			int a[] = new int[4];
			a[4] = 8; // Exception

			i = 10 / 0; // Exception
			System.out.println("Not Exceauted after Exception");

		} catch (ArithmeticException e) {

			System.err.println("Exception Handle in this Block" + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {

			System.err.println("Exception Handle in this Block" + e.getMessage());
		} catch (NullPointerException | StringIndexOutOfBoundsException e) {
			// this is also one another way.
			System.err.println("Exception Handle in this Block" + e.getMessage());
		} catch (Exception e) {

			System.err.println("Exception Handle in this Block" + e.getMessage());
		} finally {
			System.out.println(
					"Finally is Optional block for exceuated line of unexceptional code which is definetely Executed \nNot Wait for try and Catch Block is Separate optional block which Execute ur code conformly.");
		}

	}

}
