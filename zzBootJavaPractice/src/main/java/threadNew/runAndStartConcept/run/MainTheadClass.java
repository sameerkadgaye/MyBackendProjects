/**
 * 
 */
package threadNew.runAndStartConcept.run;

/**
 * @author Sameer Kadgaye
 *
 */
public class MainTheadClass {

	
	public static void main(String[] args) {
		ThreadClass threadClass = new ThreadClass();
		threadClass.run(); //Execute sequential or synchronized way And Main Thread will handle all Tasks 
							//No new Thread create For execution
							//main thread will handle everything
		for (int i = 0; i < 5; i++) {
			System.out.println("Inside Thread ==> "+Thread.currentThread().getName()+" Count = "+i);			
		}
		
	}

}
