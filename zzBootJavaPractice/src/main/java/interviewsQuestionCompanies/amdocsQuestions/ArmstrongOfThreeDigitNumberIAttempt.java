/**
 * 
 */
package interviewsQuestionCompanies.amdocsQuestions;

/**
 * @author SAMEER KADGAYE
 *
 */
public class ArmstrongOfThreeDigitNumberIAttempt {

	public static int getArmstrong(int a, int b, int c) {
		a= a*a*a;
		b= b*b*b;
		c= c*c*c;
		return a + b + c;
	}

	public static void main(String[] args) {
		
		int armstrongVal = 371;
		int armstrongCal = getArmstrong(3, 7, 1);
		
		String number = String.valueOf(armstrongVal);
		System.out.println(number);
		
		System.out.println(armstrongCal);
		if (armstrongVal == armstrongCal) {
			System.out.println("Value Is Matched With Amstrong Value Provided Statically : "+armstrongCal);
		}
	}

}
