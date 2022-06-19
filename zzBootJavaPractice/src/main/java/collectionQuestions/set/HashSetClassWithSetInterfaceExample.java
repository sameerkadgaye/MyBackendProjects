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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Sameer Kadgaye
 *
 */
public class HashSetClassWithSetInterfaceExample {
	
	public static void startingIntroduction() {
		System.out.println("<<<<<<<================== HashSet Introduction Started ==================>>>>>>>");
		Set<String> student = new HashSet<>();  //• HashSet class implements Set Interface, Undeline Datastructure is HashTable.
												//• It represents the collection that uses a hash table for storage. Hashing is used to store the elements in the HashSet. 
												//• It contains unique items (Duplicates No Allowed).
												//• Not maintain insertion order
												//• Hetrogenous objects are allowed [Except TreeSet & TreeMap Everywhere Hetrogenous Objects Are Allowed.
												//• Not Allow Duplicates.
												//• Null accepted
		
		student.add("sameer");  //boolean java.util.Set.add(String e) if arg passed string is not present in list it return true and go ahead for add in Hashset vice-versa for false.
		student.add("sanket");
		student.add("rahul");
		student.add("sagar");
		student.add("palash");
		student.add("sameer"); // Not Allow Duplicates / And Not Giving Any Error B'coz add Method Datatype is boolean And it return false when duplicates found.
		student.add(null); // null accepted in HashSet List 

//		student.remove("sameer");
//		student.remove("sameer");
//		student.remove(2); // Remove Takes Integer as Index also
//		student.remove("sameer"); // No Any Exception Got Even After sameer name entry no more exist in List

		System.out.println(student); // Not Maintain Insertion Order From HashSet List.
		
		System.out.println("<<<<<<<================== HashSet Introduction Ended ==================>>>>>>>\n");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void aboutHashSetConstructors() {
		System.out.println("<<<<<<<================== HashSet Constructors Started ==================>>>>>>>");
		//Hashset madhe capacity toParent nahi vadhnar jith parent fill ratio Or Load Factor ha exceed nahi karat max limit(i.e ex. 0.75) parent.
		
		// Constuctors Are :
		//1) HashSet h=new HashSet();
		//   • Creates an empty HashSet object with default initial capacity 16 and default fill ratio 0.75(fill ratio is also known as load factor).
		//2) HashSet h=new HashSet(int initialcapacity);
		//   • Creates an empty HashSet object with the specified initial capacity and default fill ratio 0.75.
		//3) HashSet h=new HashSet(int initialcapacity,float fillratio);
		//   • Creates an empty HashSet object with the specified initial capacity and specified fill ratio.
		//4) HashSet h=new HashSet(Collection c); 
		//   • Ya Constructor Madhe Ha Constructor args chya collection madhe present Collection List cha Object Create karel.
		
		HashSet h=new HashSet(Arrays.asList("sameer", "kadgaye"));
		System.out.println(h);
		
		//LOAD FACTOR OR FILL RATIO :
		//After Loading the how much factor(data), a new HashSet Object will be created, That factor is called as Load Factor or Fill Ratio.
		//Kiti factor(data) load kelya var HashSet cha navin object tyaar hoil tyach factor la apan laod factor mantoy. 
		
		System.out.println("<<<<<<<================== HashSet Constructors Ended ==================>>>>>>>\n");
	}
	
	public static void aboutHashSetMethods() {
		System.out.println("<<<<<<<================== HashSet Methods Started ==================>>>>>>>");
		System.out.println("\nBy Default all Collection interface Methods Are Overide in Set Interface And HashSet Class.\n");
		System.out.println("<<<<<<<================== HashSet Methods Ended ==================>>>>>>>\n");
	}
	
	public static void internalWorkingoFHashSet() {
		System.out.println("<<<<<<<================== HashSet Internal Working Started ==================>>>>>>>\n");
		//HASHSET :
		   //1) The underlying data structure is Hashtable.
		   //2) Insertion order is not preserved and it is based on hash code of the objects.
		   //3) Duplicate objects are not allowed.
		   //4) If we are trying to insert duplicate objects we won’t get compile time error and runtime error add() method simply returns false.
		   //5) Heterogeneous objects are allowed.
		   //6) Null insertion is possible.
		   //7) Implements Serializable and Cloneable interfaces but not RandomAccess. 
		
			System.out.println("1) The underlying data structure is Hashtable.");
			System.out.println("2) Insertion order is not preserved and it is based on hash code of the objects.");
			System.out.println("3) Duplicate objects are not allowed.");
			System.out.println("4) If we are trying to insert duplicate objects we won’t get compile time error and runtime error add() method simply returns false.");
			System.out.println("5) Heterogeneous objects are allowed.");
			System.out.println("6) Null insertion is possible.");
			System.out.println("7) Implements Serializable and Cloneable interfaces but not RandomAccess.");
		
		System.out.println("\n<<<<<<<================== HashSet Internal Working Ended ==================>>>>>>>");
	}

	public static void main(String[] args) {
		startingIntroduction();
		aboutHashSetConstructors();
		aboutHashSetMethods();
		internalWorkingoFHashSet();
	}

}
