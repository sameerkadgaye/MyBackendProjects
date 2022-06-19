/**
 * 
 */
package collectionQuestions.set.sortedSetNTreeSet.comparatorInterfaceConceptINTreeSet;

import java.util.TreeSet;

/**
 * @author SAMEER KADGAYE
 *
 */
public class ComparatorInterfaceConcept {
	public static void startingIntroduction() {
		System.out.println("<<<<<<<================== Comparator Interface Introduction Started ==================>>>>>>>");
		
		//Comparator interface:
		    //• Comparator meant for customized sorting order.
			//• Comparator interface present in java.util package this interface defines the following 2 methods
			              
			//1) public int compare(Object obj1, Object Obj2);
				//Example:
			              //compare(obj1, obj2);
				//• Working 
					//	|_____________ Return -ve if and only if obj1 has to come before obj2.
				    //	|
					//	|_____________ Return +ve if and only if obj1 has to come after obj2.
					//	|
					//	|_____________ Return 0(zero) if and only if obj1 and obj2 are equal.
					//  |
			//2) public boolean equals(Objectobj); //Overide equals() method in implemented class is optional B'coz SuperClass(Object) Has already implemention of equals() method.
		
		//• Whenever we are implementing Comparator interface we have to provide implementation only for compare() method.
		//• Implementing equals() method is optional because it is already available from Object class through inheritance. 
		
		 System.out.println("A".compareTo("Z"));//-25
		 System.out.println("Z".compareTo("K"));//15
		 System.out.println("A".compareTo("A"));//0
		 //System.out.println("A".compareTo(new Integer(10)));//Test.java:8:compareTo(java.lang.String) in java.lang.String cannot be applied to (java.lang.Integer)
		 //System.out.println("A".compareTo(null));//NullPointerException 
		System.out.println("<<<<<<<================== Comparator Interface Introduction Ended ==================>>>>>>>\n");
	}
	
	private static void example1() {
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
		example1();
	}

	//CONCLUSION :
	
	//NOTE: If we are depending on default natural sorting order then the objects should be “homogeneous and comparable” otherwise we will get ClassCastException. 
	//      If we are defining our own sorting by Comparator then objects “need not be homogeneous and comparable”.
	
	//COMPARABLE VS COMPARATOR:
	//• For predefined Comparable classes default natural sorting order is already available if we are not satisfied with default natural sorting order then we can define our own
	//  customized sorting order by Comparator.
	
	//• For predefined non Comparable classes [like StringBuffer] default natural sorting order
	//  is not available we can define our own sorting order by using Comparator object.
	
	//• For our own classes [like Customer, Student, and Employee] we can define default
	//  natural sorting order by using Comparable interface. The person who is using our class, 
	//  if he is not satisfied with default natural sorting order then he can define his own sorting order by using Comparator object.


}
