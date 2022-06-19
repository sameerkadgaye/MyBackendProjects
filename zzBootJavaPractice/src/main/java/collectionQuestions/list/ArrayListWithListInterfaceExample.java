/*
 LIST INTERFACE :
 
	List interface is the child interface of Collection interface. 
	It inhibits a list type data structure in which we can store the ordered collection of objects. 
	It can have duplicate values.
	
	List interface is implemented by the classes ArrayList, LinkedList, Vector, and Stack. 
	
	
 */
package collectionQuestions.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SAMEER KADGAYE
 *
 */
public class ArrayListWithListInterfaceExample {

	public static void startingIntroduction() {
		System.out.println("<<<<<<<================== Array List Introduction Started ==================>>>>>>>");
		List<String> student = new ArrayList<>(); // It uses a dynamic array(Resizable & Growable Array) to store the duplicate element of different
													// data types. The ArrayList class maintains the insertion order and
													// is non-synchronized. The elements stored in the ArrayList class
													// can be randomly accessed.
													
													//Hetrogenous objects are allowed [Except TreeSet & TreeMap Everywhere Hetrogenous Objects Are Allowed.
		
													// maintain insertion order, Allow Duplicates, Null accepted, And non synchronized.
		
		//WHAT DOES IT MEAN ARRAYLIST IS NOT SYNCHRONIZED?
		
		//Implementation of arrayList is not synchronized is by default. 
		//It means if a thread modifies it structurally and multiple threads access it concurrently,
		//it must be synchronized externally. Structural modification means addition or deletion of element(s) 
		//from the list or explicitly resizes the backing array. Changing the value of existing element is not structural modification.

		//There are two way to create Synchronized Arraylist.
		//1. Collections.synchronizedList() method.
		//2. Using CopyOnWriteArrayList.

		
		
		student.add("sameer");
		student.add("sanket");
		student.add("rahul");
		student.add("sagar");
		student.add("palash");
		student.add("sameer"); // Allow Duplicates
		student.add(null); // null accepted in Array List

		student.remove("sameer");
		student.remove("sameer");
		student.remove(2); // Remove Takes Integer as Index also
		student.remove("sameer"); // No Any Exception Got Even After sameer name entry no more exist in List

		System.out.println(student); // Maintain Insertion Order From Array List.
		System.out.println("<<<<<<<==================  Array List Introduction Ended  ==================>>>>>>>\n");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void aboutArrayListConstructors() {
		System.out.println("<<<<<<<================== Array List Constructors Started ==================>>>>>>>");
		//1)
		ArrayList<String> firstConstructorAL = new ArrayList();
												  //1>. Ya Constructor Madhe Ha Empty ArrayList cha Object Create karel with Default Intial Capacity 10 sobat.
												 // Jevha ArrayList Hi reached karel Tyachya MAX capcity parent tevha Navin ArrayList Created hoil with
												// new Capacity ni with formula =>>  int newCapacity = oldCapacity + (oldCapacity >> 1)
																					//i.e int newCapcity = 10 + ( 1010 (i.e binary of 10  number) >> 1)
																				    // 1010 >> 1 = 101 (And Binary to number Of 101 is 7) round brackets chya block cha answer
																					// now ata 10 + 7 >> 1 karel punha b'coz >> operator () block madhe hota tar to purn calcilation hot parent sobat rahil.
																					//then 10 + 7 = 17 is answer
																					// then 17 >> 1 (i.e 17 cha binary 10001 madhun sevatcha digit kadun ghyacha)
																					// 17 >> 1 = 1000 (Ani 1000 ha bianry to number ahe 15 sathi so answer is 15)
																					// int newCapacity = 15;
												
												//Binary Number Pattern For calculation :    ....  64 32 16 8 4 2 1     //Used For (Bitwise Shifting Operator Left(<<) & Right(>>) )
											
											// By default Intial Capacity ArrayList Chi hi 10 aste.
		
		//2)
		ArrayList<String> secondConstructorAL = new ArrayList(12); //new ArrayList(int intilCapacity);
											//1>. Ya Constructor Madhe Ha Empty ArrayList cha Object Create karel with customized Intial Capacity 12 ni, baki sarv same.
		
		
		//3)
		ArrayList<String> thirdConstructorAL = new ArrayList(Arrays.asList("sameer", "Kadgaye")); //new ArrayList(Collection c);
										   //1>. Ya Constructor Madhe Ha Constructor chya collection madhe present Collection List cha Object Create karel with default Intial Capacity 10 ni, baki sarv same.
		
		System.out.println(thirdConstructorAL); //Internally it used toString() method to print data of list in array format.
		System.out.println("<<<<<<<==================  Array List Constructors Ended  ==================>>>>>>>\n");
	}
	
	
	public static void internalWorkingoFArrayList() {
		System.out.println("<<<<<<<================== Array List Internal Working Started ==================>>>>>>>\n");
		
		//•  Usually we can use collection to hold and transfer objects to provide support for this
		//	  requirement every collection class implements Serializable and Cloneable interfaces,
		//•  ArrayList and Vector classes implements RandomAccess interface so that any random
		//    element we can access with the same speed.
		//•  RandomAccess interface present in util package and doesn’t contain any methods. It is a
		//    marker interface
		
		//1> Ya madhe Pratek Collection he Serializable and Cloneable marker interfaces he used kartat data store ani clone karnyasathi.
		
		//2> Tasech ArrayList ha data store karanysathi Object class chya Array (Object []) cha used karto.
		
		//3> ArrayList Ha index wise yakhadya value la add kiva remove karnyasathi Array Data la shifting karnya sathi externally code exceute karat asto.
		//   tya mude data shift karnyasathi thoda ved lagto as compare to Linked List. Jar Apli Requirement hi Data Manupaltion (Add, remove ..) sathi asel tar LinkedList
		//   Ha Best Option Ahe Than Linked List Peksha.
		
		//4> ArrayList and Vector classes he implements karatat RandomAccess marker interface la. tya mude apan kontya pan index chya record ha same kiva similar (i.e 1 or 2 sec) 
		//   speed ni access karu sakto. Jar Apli Requirement hi Data Fetching or retrieval sathi asel tar ArrayList Ha Best Option Ahe Than Linked List Peksha.
		
		//5> RandomAccess interface present in util package madhe asto ani to ek marker interface ahe.
		System.out.println("1> Collections madhe Pratek Collection he Serializable and Cloneable marker interfaces he used kartat data store ani clone karnyasathi.\n");
		System.out.println("2> Tasech ArrayList ha data store karanysathi Object class chya Array (Object []) cha used karto.\n");
		System.out.println(
				"3> ArrayList Ha index wise yakhadya value la add kiva remove karnyasathi Array Data la shifting karnya sathi externally code exceute karat asto.\n tya mude data shift karnyasathi thoda ved lagto as compare to Linked List. Jar Apli Requirement hi Data Manupaltion (Add, remove ..) sathi asel tar LinkedList \n Ha Best Option Ahe Than Linked List Peksha.\n");
		System.out.println("4> ArrayList and Vector classes he implements kartat RandomAccess marker interface la. tya mude apan kontya pan index chya record ha same kiva similar (i.e 1 or 2 sec) \n speed ni access karu sakto. Jar Apli Requirement hi Data Fetching or retrieval sathi asel tar ArrayList Ha Best Option Ahe Than Linked List Peksha.\n");
		System.out.println("5> RandomAccess interface present in util package madhe asto ani to ek marker interface ahe.");
		
		//CONCLUSION :
			//• ArrayList is the best choice if our frequent operation is retrieval Operation, (B'coz ArrayList is implements RamdomAccess Interface).
			//• ArrayList is the worst choice if our frequent operation is insertion or delete in the middle (B'coz several shift operation are require).
		System.out.println("<<<<<<<==================  Array List Internal Working Ended ==================>>>>>>>");
	}
	
	public static void main(String[] args) {
		startingIntroduction();
		aboutArrayListConstructors();
		internalWorkingoFArrayList();
	}

}
