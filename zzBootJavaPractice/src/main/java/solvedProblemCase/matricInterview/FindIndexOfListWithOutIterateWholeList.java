/**
 * 
 */
package solvedProblemCase.matricInterview;

import java.util.Arrays;
import java.util.List;

/**
 * @author SAMEER KADGAYE
 *
 */
public class FindIndexOfListWithOutIterateWholeList {
	public static void main(String[] args) {
		List<Integer> myList = Arrays.asList(2,4,5,6,9,1);
		System.out.println(myList.indexOf(5)); //2
		System.out.println(myList.indexOf(10)); //-1 if index not found for given provided value it returns -1.
		System.out.println(myList.contains(5)); // true  //contains(5) Ha check karto ki dilela value ha list madhe ahe ki nahi te.
		System.out.println(myList.contains(10)); // false
	}
}
