/*
 COLLECTION INTERFACE : 
 
		The Collection interface is the interface which is implemented by all the classes in the collection framework. 
		It declares the methods that every collection will have. 
		In other words, we can say that the Collection interface builds the foundation on which the collection framework depends.
		
		Some of the methods of Collection interface are Boolean add ( Object obj), Boolean addAll ( Collection c), void clear(), etc. 
		which are implemented by all the subclasses of Collection interface.
 */
package collectionQuestions.collectionInterface;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

/**
 * @author Sameer Kadgaye
 *
 */
public class CollectionInterfaceExample {

	public static void main(String[] args) {

// 		Collection Interface Is Parent Hirechy of All Classes. So That It Access Every Classes.
		Collection<String> student1 = new ArrayList<>();
		student1.add("");
		Collection<String> student2 = new LinkedList<>();
		student2.add("");
		Collection<String> student3 = new Vector<>();
		student3.add("");
		Collection<String> student4 = new Stack<>();
		student4.add("");
		Collection<String> student5 = new ArrayDeque<>();
		student5.add("");
		Collection<String> student6 = new ArrayDeque<>();
		student6.add("");
		Collection<String> student7 = new PriorityQueue<>();
		student7.add("");
		Collection<String> student8 = new HashSet<>();
		student8.add("");
		Collection<String> student9 = new LinkedHashSet<>();
		student9.add("");
		Collection<String> student10 = new TreeSet<>();
		student10.add("");
	}

}
