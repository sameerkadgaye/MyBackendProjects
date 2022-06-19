/**
 * 
 */
package exceptionHandling;

/**
 * @author sameer
 *
 */
public class BasicExceptionDemo {

	public static void main(String[] args) {

		int i;

		System.out.println(
				"Anything after exception not Executed/\nFor Handle this situation we need Try Catch block\n\nTry is for write code where exception occurs \nCatch for That Exception through Catch Block.\n");

		try {
			// If this block Doesn't Having ANY Exception then only this Try Block Executed
			System.out.println("Put Here That thing wheater Exception Occur's");
			i = 10 / 0; // Exception
			System.out.println("Anything after exception not exceututed"); // Not Executed after exception.
		} catch (Exception e) {
			/*
			 * This Block is Executed When Any Exception Occurs in Try Block /\nIf Any
			 * Exception is not Occurs in Try Block Then Only Try Executed
			 */
			System.err.println("Exception Handle in this Block" + e.getMessage());
		} finally {
			// i = 10 / 0; // We cant do the same exception thing in finally block
			System.out.println(
					"Finally is Optional block for exceuated line of unexceptional code which is definetely Executed \nNot Wait for try and Catch Block is Separate optional block which Execute ur code conformly.");
		}

	}

}
