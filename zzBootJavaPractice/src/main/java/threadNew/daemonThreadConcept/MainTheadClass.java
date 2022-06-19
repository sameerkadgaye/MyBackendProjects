/**
 * 
 */
package threadNew.daemonThreadConcept;

/**
 * @author SAMEER KADGAYE
 *
 */
public class MainTheadClass {
	//Daemon thread hi low priority thread aste.
	
	//Daemon thread hi fact main thread chya exceution parentch chalel jasi main thread cha 
	//exceution sampla tasi daemon thread pan automatic exist karel swata la
	
	public static void main(String[] args) {
		ThreadClass threadClass = new ThreadClass();
		threadClass.setName("AwsomeTHread");
		threadClass.setDaemon(true);
		threadClass.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Inside Thread ==> "+Thread.currentThread().getName()+" Count = "+i);			
		}
		
	}

}
