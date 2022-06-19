/**
 * 
 */
package roughWork;

import java.util.Scanner;

/**
 * @author SAMEER KADGAYE
 *
 */
public class Test {
	//(){} {()} {(})
	public static void main(String[] args) {
		Parser X = new Parser();
		Scanner sc = new Scanner(System.in);
		System.out.print("Please Enter A Input : ");
		while (sc.hasNext()) {
//			String input = sc.next();
//			System.out.println(input);
			// Complete the code
			System.out.println(X.checkParenthesesBalance(sc.next()));
		}
	}

}
