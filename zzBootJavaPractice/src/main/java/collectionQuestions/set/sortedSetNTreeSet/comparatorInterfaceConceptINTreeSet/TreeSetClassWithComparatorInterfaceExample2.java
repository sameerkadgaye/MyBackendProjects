/**
 * 
 */
package collectionQuestions.set.sortedSetNTreeSet.comparatorInterfaceConceptINTreeSet;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author SAMEER KADGAYE
 *
 */
@SuppressWarnings("rawtypes")
public class TreeSetClassWithComparatorInterfaceExample2 implements Comparator {
//Example For Decending Order Of Number By Using Numbers
	@Override
	public int compare(Object o1, Object o2) {
		 Integer i1=(Integer)o1;
		 Integer i2=(Integer)o2;
		 if(i1<i2)
		 return +1;
		 else if(i1>i2)
		 return -100;
		 else return 0; 
	}
	
	public static void aboutProblemScenario() {
		System.out.println("<<<<<<<================== About Problem Scenario Started ==================>>>>>>>\n");
		
		//• At line “1” if we are not passing Comparator object then JVM will always calls
		//  compareTo() method which is meant for default natural sorting order(ascending order)hence in this case the output is [0, 5, 10, 15, 20].
		
		//• At line “1” if we are passing Comparator object then JVM calls compare() method of
		//  MyComparator class which is meant for customized sorting order(descending order) hence in this case the output is [20, 15, 10, 5, 0]. 
		
		System.out.println("1) At line “1” if we are not passing Comparator object then JVM will always calls compareTo() method which is meant for default natural sorting order(ascending order)hence in this case the output is [0, 5, 10, 15, 20].");
		System.out.println("2) At line “1” if we are passing Comparator object then JVM calls compare() method of MyComparator class which is meant for customized sorting order(descending order) hence in this case the output is [20, 15, 10, 5, 0].");
		
		System.out.println("<<<<<<<================== About Problem Scenario Started ==================>>>>>>>\n");
	}
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		 System.out.println("REQUIREMENT: Write a program to insert String objects into the TreeSet where the sorting order is Acending order.");
		 TreeSet t1=new TreeSet();//------------(1) 
		 t1.add(10);
		 t1.add(0);
		 t1.add(15);
		 t1.add(5);
		 t1.add(20);
		 System.out.println(t1); //[0, 5, 10, 15, 20]
		
		 System.out.println("\nREQUIREMENT: Write a program to insert String objects into the TreeSet where the sorting order is Decending order.");
		 TreeSet t=new TreeSet(new TreeSetClassWithComparatorInterfaceExample2());//------------(1) 
		 t.add(10);   //[10]
		 
		 			 // +ve
		 t.add(0);   //------>> compare(0,10) => [10,0]
		 			
		 			 // -ve
		 t.add(15);  //------>> compare(15, 10) => [15, 10, 0]
		
		 			 // +ve
		 t.add(5);   //------>> compare(5, 15) => [15, 5, 10, 0]
		 
		             // +ve                                     
		             //------>> compare(5, 10) => [15, 10, 5, 0]
		 
		             // -ve                                     
		             //------>> compare(5, 0) => [15, 10, 5, 0]
		 
		 //like wise so. on
		 			 // +ve
		 t.add(20);  //------>> compare(20, 15) => [20, 15, 10, 5, 0]
		 System.out.println(t);//[20, 15, 10, 5, 0] 
		 aboutProblemScenario();
	}

}
