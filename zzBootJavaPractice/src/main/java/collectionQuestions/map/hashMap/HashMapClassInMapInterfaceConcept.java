/**
 * 
 */
package collectionQuestions.map.hashMap;

/**
 * @author SAMEER KADGAYE
 *
 */
public class HashMapClassInMapInterfaceConcept {

	public static void startingIntroduction() {
		System.out.println("<<<<<<<================== HashMap Introduction Started ==================>>>>>>>");
		
		//HASHMAP:
		    //• 1) The underlying data structure is Hashtable.
			//• 2) Duplicate keys are not allowed but values can be duplicated.
			//• 3) Insertion order is not preserved and it is based on hash code of the keys.
			//• 4) Heterogeneous objects are allowed for both key and value.
			//• 5) Null is allowed for keys(only once) and for values(any number).
			
			//• Differences between HashMap and Hashtable?
		
			//		    HASHMAP 															HASHTABLE
			//1) No method is synchronized(Non-Synchronized).					1) Every method is synchronized.
			//2) Multiple Threads can operate									2) Multiple Threads can’t operate
			//   simultaneously on HashMap object and							   simultaneously on Hashtable object
			//   hence it is not Thread safe.									   and hence Hashtable object is Thread safe.
			//
			//3) Relatively performance is high. 								3) Relatively performance is low.
			//4) Null is allowed for both key and value. 						4) Null is not allowed for both key and
			//																	   value otherwise we will get
			//																	   NullPointerException.
			//5) It is non legacy and introduced in 1.2v.					    5) It is legacy and introduced in 1.0v
		
		
		
		    //• Differences between HashMap and LinkedHashMap?
		
			//			HASHMAP 												LINKEDHASHMAP
			//1) The underlying data structure is Hashtable.			1) The underlying data structure is a combination of Hashtable+ LinkedList.
			//2) Insertion order is not preserved. 					    2) Insertion order is preserved.
			//3) introduced in 1.2.v. 								    3) Introduced in 1.4v.


		System.out.println("<<<<<<<================== HashMap Introduction Ended ==================>>>>>>>");
	}
	
	public static void aboutHashMapConstructors() {
		System.out.println("<<<<<<<================== HashMap Constructors Started ==================>>>>>>>");
		
		//• Constructors:
			//1) HashMap m=new HashMap();
			//       • Creates an empty HashMap object with default initial capacity 16 and default fill ratio “0.75”.
			//2) HashMap m=new HashMap(int initialcapacity);
			//3) HashMap m =new HashMap(int initialcapacity, float fillratio);
			//4) HashMap m=new HashMap(Map m); 
		
		System.out.println("<<<<<<<================== HashMap Constructors Ended ==================>>>>>>>");
	}
	
	public static void main(String[] args) {
		startingIntroduction();
	}

}
