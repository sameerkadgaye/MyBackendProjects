/*
 LIST INTERFACE :
 
	List interface is the child interface of Collection interface. 
	It inhibits a list type data structure in which we can store the ordered collection of objects. 
	It can have duplicate values.
	
	List interface is implemented by the classes ArrayList, LinkedList, Vector, and Stack. 
	
	
 */
package collectionQuestions.list;

import java.util.List;
import java.util.Stack;

/**
 * @author Sameer Kadgaye
 *
 */
public class StackWithListInterfaceExample {

	public static void main(String[] args) {

		List<String> student = new Stack<>(); // The stack is the subclass of Vector. It implements the
												// last-in-first-out data structure, i.e., Stack. The stack contains all
												// of the methods of Vector class and also provides its methods like
												// boolean push(), boolean peek(), boolean push(object o), which defines
												// its properties.
												// maintain insertion order, Allow Duplicates, Null accepted, And synchronized.

		student.add("sameer");
		student.add("sanket");
		student.add("rahul");
		student.add("sagar");
		student.add("palash");
		student.add("sameer"); // Allow Duplicates
		student.add(null); // null accepted in Stack List
//
//		student.remove("sameer");
//		student.remove("sameer");
//		student.remove(2); // Remove Takes Integer as Index also
//		student.remove("sameer"); // No Any Exception Got Even After sameer name entry no more exist in List

		System.out.println(student); // Maintain Insertion Order From Stack List.

	}

}
