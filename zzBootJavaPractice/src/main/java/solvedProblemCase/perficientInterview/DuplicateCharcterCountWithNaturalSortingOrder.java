/**
 * 
 */
package solvedProblemCase.perficientInterview;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author SAMEER KADGAYE
 *
 */
public class DuplicateCharcterCountWithNaturalSortingOrder {

//	input : aaabccdd
//	output: bcda
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.err.print("Please Enter A String : ");
		//System.out.err("Please Enter A String : ");
		//String sampleInput = "aaabccdd";
		String sampleInput = sc.next();

		List<String> finalChars = new ArrayList<>();
		Set<String> finalCharsMain = new LinkedHashSet<>();

		for (int i = 0; i < sampleInput.length(); i++) {
			Character c = sampleInput.charAt(i);
			String cString = c.toString();
			// System.out.println(cString);
			if (finalChars.size() > 0) {
				finalChars.forEach(cItr -> {
					if (cItr.equals(cString)) {
						int indexOfChar = finalChars.indexOf(cItr);
						//System.out.println(indexOfChar);
						finalCharsMain.add(cString);
					} else {
						finalCharsMain.add(cString);
					}
				});
			} else {
				finalChars.add(cString);
			}
		}

		System.out.println(finalCharsMain);
		// finalCharsMain.forEach(charac -> System.out.println("Set ==> "+charac));

	}
}
