/**
 * 
 */
package threadNew.runAndStartConcept;

/**
 * @author Sameer Kadgaye
 *
 */
public class MainTheadClass {

	
	public static void main(String[] args) {
		ThreadClass threadClass = new ThreadClass();
		threadClass.start(); //Execute No sequential or non synchronized way And New Thread create by Jvm For execution
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Inside Thread ==> "+Thread.currentThread().getName()+" Count = "+i);			
		}
		
//		Q) What are the tasks of start method?
//		--> Register the Thread with thread scheduler. So you just tell what a child thread should do,
//			when and how it will be scheduled will be handled by scheduler. Call run method.
		
	}

}
