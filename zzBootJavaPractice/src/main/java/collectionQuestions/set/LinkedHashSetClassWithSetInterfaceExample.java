/*
 		SET INTERFACE
 
		Set Interface in Java is present in java.util package. 
		It extends the Collection interface. 
		It represents the unordered set of elements which doesn't allow us to store the duplicate items. 
		We can store at most one null value in Set. Set is implemented by HashSet, LinkedHashSet, and TreeSet.
		
		Set can be instantiated as:

		Set<data-type> s1 = new HashSet<data-type>();  
		Set<data-type> s2 = new LinkedHashSet<data-type>();  
		Set<data-type> s3 = new TreeSet<data-type>();
 */
package collectionQuestions.set;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Sameer Kadgaye
 *
 */
public class LinkedHashSetClassWithSetInterfaceExample {
	
	public static void startingIntroduction() {
		System.out.println("<<<<<<<================== LinkedHashSet Introduction Started ==================>>>>>>>");
		
		Set<String> student = new LinkedHashSet<>();    //• For LinkedHashSet Class Undeline Datastructure is HashTable + LinkedList.
														//• LinkedHashSet class represents the LinkedList implementation of Set Interface. 
														//• It extends the HashSet class and implements Set interface.
														//• Like HashSet, It also contains unique elements. 
														//• It maintains the insertion order.
														//• Not Allow Duplicates.
														//• Accept Null elements.
		
		student.add("sameer"); //boolean java.util.Set.add(String e) if arg passed string is not present in list it return true and go ahead for add in Hashset vice-versa for false.
		student.add("sanket");
		student.add("rahul");
		student.add("sagar");
		student.add("palash");
		student.add("sameer"); // Not Allow Duplicates / And Not Giving Any Error B'coz add Method Datatype is boolean And it return false when duplicates found.
		student.add(null); // null Accepted in LinkedHashSet List

		//student.remove("sameer");
		//student.remove("sameer");
		//student.remove(2); // Remove Takes Integer as Index also
		//student.remove("sameer"); // No Any Exception Got Even After sameer name entry no more exist in List

		System.out.println(student); // Maintain Insertion Order From LinkedHashSet List.
		System.out.println("<<<<<<<================== LinkedHashSet Introduction Started ==================>>>>>>>");
	}
	
	public static void internalWorkingoFHashSet() {
		System.out.println("<<<<<<<================== LinkedHashSet Internal Working Started ==================>>>>>>>\n");
		
		//LINKEDHASHSET:
			//1) It is the child class of HashSet.
			//2) LinkedHashSet is exactly same as HashSet except the following differences.
		
			//        HASHSET                                                        LINKEDHASHSET
			//1) The underlying data structure is Hashtable.         1) The underlying data structure is a combination of LinkedList and Hashtable.
			//2) Insertion order is not preserved.                   2) Insertion order is preserved.
			//3) Introduced in 1.2 v.                                3) Introduced in 1.4v.
		
		//CONCLUSION :
		 //• LinkedHashSet Ha Tevha Use karava jevha duplicates nahi pahije Ani order maintain pahije.
		
		System.out.println("<<<<<<<================== LinkedHashSet Internal Working Started ==================>>>>>>>\n");
	}

	public static void main(String[] args) {
		startingIntroduction();
	}

}
