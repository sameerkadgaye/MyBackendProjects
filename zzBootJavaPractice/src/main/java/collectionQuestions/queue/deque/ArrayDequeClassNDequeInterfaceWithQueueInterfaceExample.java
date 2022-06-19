/*
 DEQUE INTERFACE :

		Deque interface extends the Queue interface. In Deque, we can remove and add the elements from both the side. 
		Deque stands for a double-ended queue which enables us to perform the operations at both the ends.
		
		Deque can be instantiated as:
		
		Deque d = new ArrayDeque();  
		
 ARRAYDEQUE :

		ArrayDeque class implements the Deque interface. It facilitates us to use the Deque. 
		Unlike queue, we can add or delete the elements from both the ends.
		
		ArrayDeque is faster than ArrayList and Stack and has no capacity restrictions.



 QUEUE INTERFACE :
 
		Queue interface maintains the first-in-first-out order. It can be defined as an ordered list that is used to hold the 
		elements which are about to be processed. There are various classes like PriorityQueue, Deque, 
		and ArrayDeque which implements the Queue interface.
		
		Queue interface can be instantiated as:
		
		Queue<String> q1 = new PriorityQueue();  
		Queue<String> q2 = new ArrayDeque();
		
		
		
		
 */
package collectionQuestions.queue.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Sameer Kadgaye
 *
 */
public class ArrayDequeClassNDequeInterfaceWithQueueInterfaceExample {

	public static void main(String[] args) {

		Deque<String> student = new ArrayDeque<>(); // Deque interface extends the Queue interface. In Deque, we can
													// remove and add the elements from both the side. Deque stands for
													// a double-ended queue which enables us to perform the operations
													// at both the ends.
									
		  											// Maintain insertion order, Allow Duplicates, Null Not accepted, And non synchronized Implementation.

		student.add("sameer");
		student.add("sanket");
		student.add("rahul");
		student.add("sagar");
		student.add("palash");
		student.add("sameer"); // Allow Duplicates
		// student.add(null); // null Not Accepted in ArrayDeque List

//		student.remove("sameer");
//		student.remove("sameer");
//		student.remove(2); //Remove Takes Integer as Index also
//		student.remove("sameer"); // No Any Exception Got Even After sameer name entry no more exist in List

		System.out.println(student); // Maintain Insertion Order From Deque / ArrayDeque Interface List.
	}

}
