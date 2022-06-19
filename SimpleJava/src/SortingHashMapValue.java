import java.io.*;
import java.util.*;
/**
 * 
 */

/**
 * @author SAMEER KADGAYE - Candidate
 *
 */
public class SortingHashMapValue {
	public static void main(String[] args) {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		List<String> myList = new ArrayList<String>();
		hashMap.put(2, "Student");
		hashMap.put(3, "Teacher");
		hashMap.put(1, "Employee");
		hashMap.put(4, "Banker");
		
		hashMap.forEach((k,v)->{
			myList.add(v);
		});
		Collections.sort(myList);
		System.out.println(myList);
	}
}
