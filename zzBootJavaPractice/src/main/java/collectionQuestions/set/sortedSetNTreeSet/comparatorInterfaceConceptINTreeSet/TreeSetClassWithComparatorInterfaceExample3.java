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
public class TreeSetClassWithComparatorInterfaceExample3 implements Comparator {
	
//REQUIREMENT: Write a program to insert String objects into the TreeSet where the sorting order is reverse of alphabetical order
//Example For Decending Order Of Alphabets By Using Numbers
	
	@Override
	public int compare(Object o1, Object o2) {
		String s1=o1.toString();
		String s2=(String)o2;
		//return s2.compareTo(s1);
		return -s1.compareTo(s2);
	}
	
	public static void aboutProblemScenario() {
		System.out.println("<<<<<<<================== About Problem Scenario Started ==================>>>>>>>\n");
		
		//• At line “1” if we are not passing Comparator object then JVM will always calls
		//  compareTo() method which is meant for default natural sorting order(ascending order)hence in this case the output is [GangaBhavani, RajaKumari, Ramulamma, Roja, ShobaRani].
		
		//• At line “1” if we are passing Comparator object then JVM calls compare() method of
		//  MyComparator class which is meant for customized sorting order(descending order) hence in this case the output is [ShobaRani, Roja, Ramulamma, RajaKumari, GangaBhavani]. 
		
		System.out.println("1) At line “1” if we are not passing Comparator object then JVM will always calls compareTo() method which is meant for default natural sorting order(ascending order)hence in this case the output is [0, 5, 10, 15, 20].");
		System.out.println("2) At line “1” if we are passing Comparator object then JVM calls compare() method of MyComparator class which is meant for customized sorting order(descending order) hence in this case the output is [20, 15, 10, 5, 0].");
		
		System.out.println("<<<<<<<================== About Problem Scenario Started ==================>>>>>>>\n");
	}
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		 System.out.println("REQUIREMENT: Write a program to insert String objects into the TreeSet where the sorting order is reverse of alphabetical order.\n");
		 TreeSet t1=new TreeSet();//------------(1) 
		 t1.add("Roja");
		 t1.add("ShobaRani");
		 t1.add("RajaKumari");
		 t1.add("GangaBhavani");
		 t1.add("Ramulamma");
		 System.out.println(t1); //[GangaBhavani, RajaKumari, Ramulamma, Roja, ShobaRani].
		 
		 System.out.println("\nREQUIREMENT: Write a program to insert String objects into the TreeSet where the sorting order is reverse of alphabetical order.");
		 TreeSet t=new TreeSet(new TreeSetClassWithComparatorInterfaceExample3());//------------(1) 
		 t.add("Roja");
		 t.add("ShobaRani");
		 t.add("RajaKumari");
		 t.add("GangaBhavani");
		 t.add("Ramulamma");
		 System.out.println(t);//[ShobaRani, Roja, Ramulamma, RajaKumari, GangaBhavani]
		 aboutProblemScenario();
	}

}
