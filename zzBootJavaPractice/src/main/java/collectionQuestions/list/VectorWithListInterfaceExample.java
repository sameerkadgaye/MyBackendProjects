/*
 LIST INTERFACE :
 
	List interface is the child interface of Collection interface. 
	It inhibits a list type data structure in which we can store the ordered collection of objects. 
	It can have duplicate values.
	
	List interface is implemented by the classes ArrayList, LinkedList, Vector, and Stack. 
	
	
 */
package collectionQuestions.list;

import java.util.List;
import java.util.Vector;

/**
 * @author sameer.kadgaye
 *
 */
public class VectorWithListInterfaceExample {

	public static void main(String[] args) {

		List<String> student = new Vector<>(); // Vector uses a dynamic array to store the data elements. It is similar
												// to ArrayList. However, It is synchronized and contains many methods
												// that are not the part of Collection framework.
												// maintain insertion order, Allow Duplicates, Null accepted, And synchronized.

		student.add("sameer");
		student.add("sanket");
		student.add("rahul");
		student.add("sagar");
		student.add("palash");
		student.add("sameer"); // Allow Duplicates
		student.add(null); // null accepted in Vector List

		student.remove("sameer");
		student.remove("sameer");
		student.remove(2); // Remove Takes Integer as Index also
		student.remove("sameer"); // No Any Exception Got Even After sameer name entry no more exist in List

		System.out.println(student); // Maintain Insertion Order From Vector List.

	}

}
