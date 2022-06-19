/*
 
 A FUNCTIONAL INTERFACE can have methods of object class. See in the following example.
 
 EXAMPLE 2 :-
  
 */
package functional_Inteface_concepts;

/**
 * @author Sameer Kadgaye
 *
 */
@FunctionalInterface
interface sayable1 {
	public abstract void say(String msg);  //or void say();
	
	// It can contain any number of Object class methods.  
    int hashCode();  
    String toString();  
    boolean equals(Object obj);  
}
public class FunctionalInterfaceExample2 implements sayable1{


	@Override
	public void say(String msg) {
		System.out.println(msg);
	}
	
	public static void main(String[] args) {
		FunctionalInterfaceExample2 fie = new FunctionalInterfaceExample2();  
        fie.say("I am Executed With Functional Interface Concept.");
	}


}
