/**
 * 
 */
package dataStructureAndAlgorithms.otherLogicsModule.armstongNumber;

/**
 * @author SAMEER KADGAYE
 *
 */
public class ArmstongNumber {
	// Armstong manje jevdya digits che number chi length rahil titkya length parent
	// ek ek digit ha multiple hot rahil.
	// i.e length of number 1634 is 4 manun DIGIT * DIGIT * DIGIT * DIGIT + and So
	// On.
	// 1*1*1*1 + 6*6*6*6 + 3*3*3*3 + 4*4*4*4
	// 1+1296+81+256 = 1634

	// And i.e length of number 153 is 3 manun DIGIT * DIGIT * DIGIT + and So On.
	// 1*1*1 + 5*5*5 + 3*3*3 = 153 like wise for 3 digit length of number.

	public static void main(String[] args) {
		int mainArmstongNumber = 153;

		int tempArmstongNumber1 = mainArmstongNumber;
		int howMuchTimesDigitCanMultiplyCountLength = 0;

		while (tempArmstongNumber1 != 0) {
			howMuchTimesDigitCanMultiplyCountLength = howMuchTimesDigitCanMultiplyCountLength + 1; // l=l+1 like wise
			tempArmstongNumber1 = tempArmstongNumber1 / 10;
//			System.out.println(tempArmstongNumber1);
		}
		System.out.println("How Much Time We Provide Multiplication To Digits ==> " + howMuchTimesDigitCanMultiplyCountLength);

		int tempArmstongNumber2 = mainArmstongNumber;
		int calculatedArmstongNumber = 0;
		int remainder;
		while (tempArmstongNumber2 != 0) {
			int calculatedMultiple = 1;
			remainder = tempArmstongNumber2 % 10;

			for (int i = 1; i <= howMuchTimesDigitCanMultiplyCountLength; i++) {
				calculatedMultiple = calculatedMultiple * remainder;
			}
			calculatedArmstongNumber = calculatedArmstongNumber + calculatedMultiple;
			tempArmstongNumber2 = tempArmstongNumber2 / 10;
		}

		if (mainArmstongNumber == calculatedArmstongNumber) {
			System.out.println(mainArmstongNumber+" Given Number is Amrstong Number, its calculate Final Sum : " + calculatedArmstongNumber);
		} else {
			System.out.println(mainArmstongNumber+" Given Number is Not Amrstong Number, its Calculate Final Sum : " + calculatedArmstongNumber);
		}
	}

}
