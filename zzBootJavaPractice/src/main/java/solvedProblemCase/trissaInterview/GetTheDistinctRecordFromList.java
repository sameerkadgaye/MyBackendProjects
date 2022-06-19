/**
 * 
 */
package solvedProblemCase.trissaInterview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SAMEER KADGAYE
 *
 */
public class GetTheDistinctRecordFromList {
	
	public static void main(String[] args) {
		List<Integer> num = Arrays.asList(1, 2, 1, 4, 5, 6, 4, 6, 5, 7, 8, 9, 9, 8);
		
		List<Integer> collectDistinctListOfNumbers = num.stream().map(dnum -> dnum).distinct().collect(Collectors.toList());
		System.out.println(collectDistinctListOfNumbers);
		
		List<Integer> limitListToExceuteUpToSpecificIndex = num.stream().map(dnum -> dnum).limit(2).collect(Collectors.toList());
		System.out.println(limitListToExceuteUpToSpecificIndex);
	}
}
