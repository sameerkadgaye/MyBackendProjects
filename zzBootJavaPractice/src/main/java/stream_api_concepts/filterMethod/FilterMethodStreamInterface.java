/**
 **STREAM API filter() METHOD**
 
	 Java stream provides a method filter() to filter stream elements on the basis of given predicate. 
	 Suppose you want to get only even elements of your list then you can do this easily with the help of filter method.
	 This method takes predicate as an argument and returns a stream of consisting of resulted elements.



SIGNATURE :
			The signature of Stream filter() method is given below:
			
			Stream<T> filter(Predicate<? super T> predicate)  


PARAMETER :

			predicate: It takes Predicate reference as an argument. 
			Predicate is a functional interface. So, you can also pass lambda expression here.


RETURN :
			It returns a new stream.
 *
 */
package stream_api_concepts.filterMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Sameer Kadgaye
 *
 */
public class FilterMethodStreamInterface {

	public static void main(String[] args) {
// SOME OF WAYS TO CREATE LIST IN JAVA

		// First Way :-
		Integer myArr[] = { 2, 4, 50, 21, 22, 67 };
		List<Integer> list = Arrays.asList(myArr);
		System.out.println("Very First List ===>>> " + list); // Its Create Immutable Object of List.
		// list.add(103); //R.E Because of Immutable. #UnsupportedOperationException

		// OR

		List<Integer> list1 = Arrays.asList(2, 4, 50, 21, 22, 67, 10); // Its Create Immutable Object of List.
		System.out.println("First List ===>>> " + list1);
		// list1.add(103); //R.E Because of Immutable. #UnsupportedOperationException

		// Second Way :-
		List<Integer> myListInOldWay = new ArrayList<Integer>();
		myListInOldWay.add(10);
		myListInOldWay.add(20);
		myListInOldWay.add(30);
		myListInOldWay.add(40);
		myListInOldWay.add(50);

		System.out.println("Second List ===>>> " + myListInOldWay);
		myListInOldWay.add(80); // This List Is Mutable. Allowing Operation Of Adding New Entry.
		System.out.println("Second List With Mutable Concept ===>>> " + myListInOldWay);

// NOW LETS LEARN STREAM API CONCEPTS WITH COLLECTION.

		// PROBLEM 1 :- suppose if we want to only even number from list1 then for that,
		// we write below code.

		// WITHOUT USING STREAM API (Old Way) :-

		List<Integer> evenNumberSortedListByOldWay = new ArrayList<Integer>();

		for (Integer evenNum : list1) {
			if (evenNum % 2 == 0) {
				evenNumberSortedListByOldWay.add(evenNum);
			}
		}
		System.out.println("Even Number List Stored In Old Way ===>>  " + evenNumberSortedListByOldWay);

		// WITH USING STREAM API :-

		Stream<Integer> myStream = list1.stream();
		List<Integer> evenNumListByStream = myStream.filter(i -> i % 2 == 0).collect(Collectors.toList());

		// OR WITH USING SINGLE LINE STATEMENT
		List<Integer> evenNumListByStreamSingleStatement = list1.stream().filter(i -> i % 2 == 0)
				.collect(Collectors.toList());
		System.out.println(
				"Even Number List Stored In Stream API NEW Way In Two Statement ===>>  " + evenNumListByStream);
		System.out.println("Even Number List Stored In Stream API NEW Way In Single Statement ===>>  "
				+ evenNumListByStreamSingleStatement);

		// PROBLEM 2 :- Suppose if we want to only number which is greater than 10 from
		// list1 then for that,
		// we write below code.

		List<Integer> greaterThanTenNumList = list1.stream().filter(num -> num > 10).collect(Collectors.toList());
		System.out.println("Greater Than 10 Numbers List From list1 obj ===>>>>>>  " + greaterThanTenNumList);

	}
}
