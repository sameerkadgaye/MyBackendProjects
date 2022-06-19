package interviewsQuestionCompanies.globalLogic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Print duplicate characters in string.
//Ex - Hello, my name is Sameer
//Ouput - 
//l m e s a e
public class FindDuplicatesCharacterFromString {
	public static void main(String[] args) {
		String input = "Hello, my name is Vgipl";
		Set<String> finalDuplicates = new HashSet();
		List<String> duplicates = new ArrayList();
		// duplicates.add("H");
		
		String[] entries = input.split(" ");
		for (int i = 0; i < entries.length; i++) {
			String entry = entries[i];
			for (int j = 0; j < entry.length(); j++) {
				String s = Character.toString(entry.charAt(j));
				if (duplicates.size() > 0) {
					System.err.println("First"); 
					duplicates.forEach(d -> {
						duplicates.add(s);
						System.out.println("First ==> "+d);
						
						//System.out.println(s.trim().equals(d));
//						if (s.trim().equals(d)) {
//							System.err.println(d);
//						}
					});
					
				} else {
					System.err.println("Second ");
					duplicates.add(s);
				}
			}
		}
		
		duplicates.forEach(d -> {
			//if (s.trim().equals(d)) {
				System.err.println(d);
			//}
		});
	}
}
