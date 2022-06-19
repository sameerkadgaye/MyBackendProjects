/**
 * 
 */
package interviewsQuestionCompanies.amatyaInstitude;

import java.util.Scanner;

/**
 * @author SAMEER KADGAYE
 *
 */
public class FebbinacciSeries {
	//1 1 2 3 5 8 13
	public static void main(String[] args) {
		int firstTerm = 1, secondTerm = 1;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter Fibonacci Series Exceute till : ");
		int n = scan.nextInt();
		System.out.println("Yoo Fibonacci Series Exceute till " + n + " terms:");
		for (int i = 1; i <= n; ++i) {
			System.out.print(firstTerm + ", ");

			// compute the next term
			int nextTerm = firstTerm + secondTerm;
			firstTerm = secondTerm;
			secondTerm = nextTerm;
		}
	}
}
