/*
ITERABLE INTERFACE :

	The Iterable interface is the root interface for all the collection classes. 
	The Collection interface extends the Iterable interface and therefore all the 
	subclasses of Collection interface also implement the Iterable interface.
	
	It contains only one abstract method. i.e.,
	
	Iterator<T> iterator()  
	It returns the iterator over the elements of type T.
 */
package collectionQuestions.iterableInterface;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Sameer Kadgaye
 *
 */
public class IterableInterfaceExample {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
//		Iterable Interface contains only one abstract method. i.e.,
//		
//		Iterator<T> iterator() 

		ArrayList<String> list=new ArrayList<String>();//Creating arraylist  
		list.add("sameer");//Adding object in arraylist  
		list.add("sanket");  
		list.add("Ravi");  
		list.add("Ajay");  
		//Traversing list through Iterator  
		Iterator itr=list.iterator();  //Iterator is Method of Iterable Interface.
		while(itr.hasNext()){  
		System.out.println(itr.next());  
		}  
	}

}
