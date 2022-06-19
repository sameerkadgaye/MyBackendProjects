/**
 * 
 */
package solvedProblemCase.matricInterview;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author SAMEER KADGAYE
 *
 */
public class SecondHighestNumberFromList {

	public static void main(String[] args) {
		List<Integer> num = Arrays.asList(24, 88, 49, 69, 67);
		
		Collections.sort(num);    //asending
		//Collections.reverse(num); //decending
		System.out.println(num);  //In Here Printed in Asending & Decending order as Per Above Collections Class method.
		
		//Beheviour of size() method -->> its calculate length from 1 not from zero. so we got length 5 from above.
		//Beheviour of get() method -->> its calculate length from 0 not from zero. so we got length accordingly 4 from above.
		Integer secondHigh = num.get(num.size() - 2); //Thats we we -2 over logic to full field our requirement.
		
		System.out.println("2nd Highest Number Is : "+secondHigh);
	}

}
