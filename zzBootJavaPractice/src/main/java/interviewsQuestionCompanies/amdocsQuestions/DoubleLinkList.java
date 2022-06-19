/**
 * 
 */
package interviewsQuestionCompanies.amdocsQuestions;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sameer.kadgaye
 *
 */
public class DoubleLinkList {

	
	public static void main(String[] args) {
		List<Integer> numbers = new LinkedList();
		
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		
		numbers.remove(1); //it remove the index 1
		
		numbers.forEach(num -> {
			System.out.println(num);
		});
		
		//numbers.stream().filter(s -> s == 1).collect(Collections.to)
	}

}
