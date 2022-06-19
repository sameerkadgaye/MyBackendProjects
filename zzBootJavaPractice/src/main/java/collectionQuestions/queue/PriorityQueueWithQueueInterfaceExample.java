/*
	QUEUE INTERFACE :
	
	Queue interface maintains the first-in-first-out order. It can be defined as an ordered list that is used to hold the elements which are about to be processed. There are various classes like PriorityQueue, Deque, and ArrayDeque which implements the Queue interface.
	
	Queue interface can be instantiated as:
	
	Queue<String> q1 = new PriorityQueue();  
	Queue<String> q2 = new ArrayDeque();  
 */
package collectionQuestions.queue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Sameer Kadgaye
 *
 */
public class PriorityQueueWithQueueInterfaceExample {

	public static void main(String[] args) {

		Queue<String> student = new PriorityQueue<>(); // The PriorityQueue class implements the Queue interface. It
													   // holds the elements or objects which are to be processed by
													   // their priorities. PriorityQueue doesn't allow null values to
													   // be stored in the queue.
													
													   // not maintain insertion order, Allow Duplicates, Null Not accepted, And non synchronized Implementation.

		student.add("sameer");
		student.add("sanket");
		student.add("rahul");
		student.add("sagar");
		student.add("palash");
		student.add("zuber");
		student.add("sameer"); // Allow Duplicates
	//	student.add(null); // null Not accepted in PriorityQueue List Give NULL POINTER EXCEPTION. 

		//student.remove("sameer");
		//student.remove("sameer");
		//student.remove(2); // Remove Takes Integer as Index also
		//student.remove("sameer"); // No Any Exception Got Even After sameer name entry no more exist in List

		System.out.println(student); // not Maintain Insertion Order From PriorityQueue List.
	}

}
