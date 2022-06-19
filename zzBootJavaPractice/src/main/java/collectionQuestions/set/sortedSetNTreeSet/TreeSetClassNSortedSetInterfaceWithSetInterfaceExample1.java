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
package collectionQuestions.set.sortedSetNTreeSet;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Sameer Kadgaye
 *
 */
public class TreeSetClassNSortedSetInterfaceWithSetInterfaceExample1 {
	public static void startingIntroduction() {
		System.out.println("<<<<<<<================== SORTEDSET & TreeSet Introduction Started ==================>>>>>>>");

//		SORTEDSET INTERFACE :

//		SortedSet is the alternate of Set interface that provides a total ordering on its elements. 
//		The elements of the SortedSet are arranged in the increasing (ascending) order. 
//		The SortedSet provides the additional methods that inhibit the natural ordering of the elements.
//
//		The SortedSet can be instantiated as:
//
//		SortedSet<data-type> set = new TreeSet();  

		SortedSet<Object> student = new TreeSet<>();    // TREESET :-
														//• The underlying data structure is balanced tree.
														//• Java TreeSet class implements the Set interface that uses a tree for storage.
														//• Like HashSet, TreeSet also contains unique elements.
														//• However, the access and retrieval time of TreeSet is quite fast.
														
														//• The elements in TreeSet stored in ascending order.
														//• Maintain insertion order in Alphabetical order.
														//• Not Allow Duplicates Objects
														//• Null Not accepted.
														//• Heterogeneous objects are not allowed if we are trying to insert heterogeneous objects then we will get ClassCastException. 
														
														//• If we are depending on default natural sorting order compulsory the objects should be
														//  homogeneous and Comparable otherwise we will get ClassCastException. 
														//• String class and all wrapper classes implements Comparable interface but StringBuffer (SB In version less than jdk-11) or Others
		 												//  class doesn’t implement Comparable interface then we will get ClassCastException.
		
		//student.add(null); //Null Ha accept ahe ya index jevha TreeSet Empty Asel tevhach Otherwise. => Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Comparable.compareTo(Object)" because "k1" is null
		student.add("sameer");
		//student.add(3); //Exception in thread "main" java.lang.ClassCastException: class java.lang.String cannot be cast to class java.lang.Integer
		student.add("sanket");
		student.add("rahul");
		student.add("sagar");
		student.add("palash");
		student.add("zubair");
		
		student.add("sameer"); // Not Allow Duplicates
//		student.add(null); // For Non Empty TreeSet null Not accepted ahe pan null ha accept ahe jevha insert index ha 0 Asel Ani TreeSet ha Empty Asel tevhach.

//		student.remove("sameer");
//		student.remove("sameer");
//		student.remove(2); // Remove Takes Integer as Index also
//		student.remove("sameer"); // No Any Exception Got Even After sameer name entry no more exist in List

		System.out.println(student); // Not Maintain Insertion Order From TreeSet List.

		System.out.println("<<<<<<<================== SORTEDSET & TreeSet Introduction Ended ==================>>>>>>>");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void aboutTreeSetConstructors() {
		System.out.println("<<<<<<<================== TreeSet Constructors Started ==================>>>>>>>\n");
		//1) TreeSet t=new TreeSet();
		//    • Creates an empty TreeSet object where all elements will be inserted according to default natural sorting order. Here Comparable Interface method compareTo Used Internally.
		//2) TreeSet t=new TreeSet(Comparator c);
		//    • Creates an empty TreeSet object where all objects will be inserted according to customized sorting order specified by Comparator object.
		//3) TreeSet t=new TreeSet(SortedSet s);
		//4) TreeSet t=new TreeSet(Collection c); 
		TreeSet t=new TreeSet(Arrays.asList("A", "a", "Z", "L", "B"));
		System.out.println(t); //Print The output according to default natural sorting order (BY ASCII Code A=65 To Z=90 ... & a=97 To z=122) 
		
		//• If we are not satisfying with default natural sorting order (or) if default natural sorting
		//  order is not available then we can define our own customized sorting by Comparator object.
		//• Comparable meant for default natural sorting order.
		//• Comparator meant for customized sorting order.
		System.out.println("<<<<<<<================== TreeSet Constructors Ended ==================>>>>>>>\n");
	}
	
	public static void internalWorkingoFTreeSet() {
		System.out.println("<<<<<<<================== TreeSet Internal Working Started ==================>>>>>>>\n");
		//1) The underlying data structure is balanced tree.
		//2) Duplicate objects are not allowed.
		//3) Insertion order is not preserved and it is based on some sorting order of objects.
		//4) Heterogeneous objects are not allowed if we are trying to insert heterogeneous objects then we will get ClassCastException.
		//5) Null insertion is possible(only once).
		
		//Null acceptance:
			//• For the empty TreeSet as the 1st element “null” insertion is possible but after inserting
			//that null if we are trying to insert any other we will get NullPointerException.
		
		    //• For the non empty TreeSet if we are trying to insert null then we will get NullPointerException. 
		System.out.println("<<<<<<<================== TreeSet Internal Working Ended ==================>>>>>>>\n");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void example1() {
		System.out.println("<<<<<<<================== Example 1 Started ==================>>>>>>>");
		TreeSet t=new TreeSet();
		 t.add(new StringBuffer("A"));
		 t.add(new StringBuffer("Z"));
		 t.add(new StringBuffer("L"));
		 t.add(new StringBuffer("B"));
		 System.out.println(t);
		 
		 //Output:
			 //Runtime Exception.
			 //• Exception in thread "main" java.lang.ClassCastException: java.lang.StringBuffer cannot
			 //  be cast to java.lang.Comparable
			 //• If we are depending on default natural sorting order compulsory the objects should be
			 //  homogeneous and Comparable otherwise we will get ClassCastException.
			 //• An object is said to be Comparable if and only if the corresponding class implements
			 //  Comparable interface.
			 //• String class and all wrapper classes implements Comparable interface but StringBuffer
			 //  class doesn’t implement Comparable interface hence in the above program we are
			 //  getting ClassCastException. 
		 
		 //Note :
		 
		 //You are converting StringBuffer to String in comparator, and String class implements Comparable interface, 
		 //And also as a note since from jdk-11 StringBuffer and StringBuilder also implements Comparable
         //(a, b) -> -a.toString().compareTo(b.toString())
		 //But if you are on lower version below jdk-11 you will get the compile time error
		 System.out.println("<<<<<<<================== Example 1 Ended ==================>>>>>>>\n");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	private static void example2() {
		System.out.println("<<<<<<<================== Example1 Introduction Started ==================>>>>>>>");
		 //• If we are depending Upon Default natural sorting order internally JVM will call compareTo() method. 
		//   will inserting objects to the TreeSet. Hence the objects should be Comparable.
		
		//Example By Considering Tree Set :
			TreeSet t= new TreeSet();
			t.add("B");
			t.add("Z");  // "Z".compareTo("B"); --> =>   +ve
			t.add("A");  // "Z".compareTo("B"); --> =>   -ve
			System.out.println(t);  //O/p : [A, B, Z]
			
		//• If we are not satisfying with default natural sorting order (or) if default natural sorting
		//  order is not available then we can define our own customized sorting by Comparator object.
		//• Comparable meant for default natural sorting order.
		//• Comparator meant for customized sorting order.
		System.out.println("<<<<<<<================== Example1 Interface Introduction Ended ==================>>>>>>>");
	}


	public static void main(String[] args) {
		startingIntroduction();
		aboutTreeSetConstructors();
		internalWorkingoFTreeSet();
		example1();
		example2();
		
	}
}
