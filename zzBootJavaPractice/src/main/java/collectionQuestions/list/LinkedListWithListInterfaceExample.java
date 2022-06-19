/*
 LIST INTERFACE :
 
	List interface is the child interface of Collection interface. 
	It inhibits a list type data structure in which we can store the ordered collection of objects. 
	It can have duplicate values.
	
	List interface is implemented by the classes ArrayList, LinkedList, Vector, and Stack. 
	
	
 */
package collectionQuestions.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Sameer Kadgaye
 *
 */
public class LinkedListWithListInterfaceExample {

	public static void startingIntroduction() {
		System.out.println("<<<<<<<================== Linked List Introduction Started ==================>>>>>>>");
		List<String> student = new LinkedList<>(); // It uses a doubly linked list internally to store the elements.
													// It can store the duplicate elements. It maintains the insertion
													// order and is non synchronized. In LinkedList, the manipulation is
													// fast because no shifting is required.
		
													//Hetrogenous objects are allowed [Except TreeSet & TreeMap Everywhere Hetrogenous Objects Are Allowed.
													
													// maintain insertion order, Allow Duplicates, Null accepted, And non synchronized.

		student.add("sameer");
		student.add("sanket");
		student.add("rahul");
		student.add("sagar");
		student.add("palash");
		student.add("sameer"); // Allow Duplicates
		student.add(null); // null accepted in Linked List
		student.add(null);

		student.remove("sameer");
		student.remove("sameer");
		student.remove(2); // Remove Takes Integer as Index also
		student.remove("sameer"); // No Any Exception Got Even After sameer name entry no more exist in List

		System.out.println(student); // Maintain Insertion Order From Linked List.
		System.out.println("<<<<<<<================== Linked List Introduction Ended ==================>>>>>>>\n");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void aboutLinkedListConstructors() {
		System.out.println("<<<<<<<================== Linked List Constructors Started ==================>>>>>>>");
		LinkedList<String> firstLinkedListConstructor = new LinkedList();
														//1> Ha Constructor Create karto Empty LinkedList Object La. 
														//2> Yat kontya prakarchi capacity cha concept nasto karan ha node cha concept used kart asto data manupulations sathi.
		
		LinkedList<String> secondLinkedListConstructor = new LinkedList(Arrays.asList("sameer", "kadgaye"));
													    //1> Ya Constructor Madhe Ha Constructor chya args collection madhe present Collection List cha Object Create karel.
		System.out.println(secondLinkedListConstructor);
		System.out.println("<<<<<<<================== Linked List Constructors Ended ==================>>>>>>>\n");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void aboutLinkedListMethods() {
		System.out.println("<<<<<<<================== Linked List Methods Started ==================>>>>>>>");
		//• Usually we can use LinkedList to implement Stacks and Queues to provide support for
		//  this requirement LinkedList class defines the following 6 specific methods. (Collection & List interface chya methods sodun)
		//1> void addFirst(Object o);
		//2> void addLast(Object o);
		//3> Object getFirst();
		//4> Object getLast(); 
		//5> Object removeFirst();
		//6> Object removeLast();
		System.out.println("Collection Ani List Interface chya Methods Sodun Linked List madhe 6 Important Methods Ahet : ");
		System.out.println("\n 1> void addFirst(Object o); \n 2> void addLast(Object o); \n 3> Object getFirst(); \n 4> Object getLast(); \n 5> Object removeFirst(); \n 6> Object removeLast();");
		System.out.println("<<<<<<<================== Linked List Methods Ended ==================>>>>>>>\n");
	}
	
	public static void internalWorkingoFLinkedList() {
		System.out.println("<<<<<<<================== Linked List Internal Working Started ==================>>>>>>>\n");
		//INTERNAL WORKING :
		
		                                                                                 //  Below D Is Replaced By F and Then D Is Ready For Garbage Collector
	//  _____________         _____________         _____________         _____________    _____________    _____________         _____________  	
	// |   |     |   |----->>|   |     |   |----->>|   |     |   |----->>|   |     |   |  |   |     |   |  |   |     |   |----->>|   |     |   | 	
	//	 • |  A  | • |       | • |  B  | • |       | • |  C  | • |       | • |  D  | • |  | • |  D  | • |  | • |  G  | • |       | • |  I  | • | 	
	// |___|_____|___|<<---- |___|_____|___|<<---- |___|_____|___|<<---- |___|_____|___|  |___|_____|___|  |___|_____|___|<<---- |___|_____|___| 	
	                                                                                                                                             	
	//                                                                                ^|                    | ^                                  	
	//														                          |⌄                    ⌄ |                                  	
	//                                                                                _________________________                                  	
	//                                                                               |         |     |         |                                 	
	//                                                                               |    •    |  F  |    •    |                                 	
	//                                                                               |_________|_____|_________|                                 	
		
		//• The underlying data structure is double LinkedList. 
		//• Duplicate objects are allowed.
		//• Insertion order is preserved.
		//• Heterogeneous objects are allowed.
		//• Null insertion is possible. 
		//• Implements Serializable and Cloneable interfaces but not RandomAccess.
		//• If our frequent operation is insertion (or) deletion in the middle then LinkedList is the best choice.
		//• If our frequent operation is retrieval operation then LinkedList is worst choice.
		
		System.out.println("1> The underlying data structure is double LinkedList.");
		System.out.println("2> Duplicate objects are allowed.");
		System.out.println("3> Insertion order is preserved.");
		System.out.println("4> Heterogeneous objects are allowed.");
		System.out.println("5> Null insertion is possible.");
		System.out.println("6> Implements Serializable and Cloneable interfaces but not RandomAccess.");
		System.out.println("7> If our frequent operation is insertion (or) deletion in the middle then LinkedList is the best choice.");
		System.out.println("8> If our frequent operation is retrieval operation then LinkedList is worst choice.");
		
		//CONCLUSION :
			 //• If our frequent operation is insertion (or) deletion in the middle then LinkedList is the best choice.
			 //• If our frequent operation is retrieval operation then LinkedList is worst choice
		System.out.println("<<<<<<<================== Linked List Internal Working Ended ==================>>>>>>>\n");
	}
	public static void main(String[] args) {
		startingIntroduction();
		aboutLinkedListConstructors();
		aboutLinkedListMethods();
		internalWorkingoFLinkedList();
	}
	
		
	//  _____________         _____________         _____________         _____________    _____________    _____________         _____________ 
	// |   |     |   |----->>|   |     |   |----->>|   |     |   |----->>|   |     |   |  |   |     |   |  |   |     |   |----->>|   |     |   |
	//	 • |  A  | • |       | • |  B  | • |       | • |  C  | • |       | • |  D  | • |  | • |  D  | • |  | • |  G  | • |       | • |  I  | • |
	// |___|_____|___|<<---- |___|_____|___|<<---- |___|_____|___|<<---- |___|_____|___|  |___|_____|___|  |___|_____|___|<<---- |___|_____|___|

	//                                                                                ^|                    | ^
	//														                          |⌄                    ⌄ |
	//                                                                                _________________________ 
	//                                                                               |         |     |         |   
	//                                                                               |    •    |  F  |    •    |
	//                                                                               |_________|_____|_________|
	
	
}
