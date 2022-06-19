package interviewsQuestionCompanies.globalLogic;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 */

/**
 * @author sameer
 *
 */
public class FindNotDuplicatesCharacterFromString {

	public static void main(String[] args) {
		String input = "Hello, my name is Sameer";
		
		Set<Character> duplicates = new HashSet<Character>();
		String[] entries = input.split(" ");

		for (int i = 0; i < entries.length; i++) {
			System.out.println(entries[i]);
			System.out.println(entries[i].length());
			String entry = entries[i];
			for (int j = 0; j < entry.length(); j++) {
				duplicates.add(entry.charAt(j));
			}
			
//			String entry = entries[i];
//			System.out.println(entry.length());
//			for (int j = 0; j < entry.length(); j++) {
//				System.out.println("Check char ==> "+entry.charAt(j));
//				char charAt = entry.charAt(j);
//				if (duplicates.size() < 0) {
//					duplicates.forEach(dup -> {
//						if (charAt == dup) {
//							//System.out.println("Duplicated");
//						} else {
//							duplicates.add(charAt);
//						}
//					});
//				} else {
//					duplicates.add(charAt);
//				}
//				
//			}
		}
		System.out.print("\n\n");
		duplicates.forEach(d -> {
			System.out.print(d);
		});
	}
}
