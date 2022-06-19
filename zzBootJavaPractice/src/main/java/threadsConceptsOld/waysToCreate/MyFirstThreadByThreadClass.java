/**
 * 
 */
package threadsConceptsOld.waysToCreate;

/**
 * @author Sameer Kadgaye
 *
 */

//Thread Class have only start() method. 
//Reason Behind run() method having in Thread class beacuse. Internally Thread Class Implements Runnable Interface.
//And Runnable Interface Having run() method.
//So That from above Thread Class Having Two Main Method Those Are responsible for operate thread.
// 1. start() And
// 2. run().
public class MyFirstThreadByThreadClass extends Thread{

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Hello ==> "+i);
		} 
	}
	
	public static void main(String[] args) {
		MyFirstThreadByThreadClass byThreadClass = new MyFirstThreadByThreadClass();
		//byThreadClass.run();
		//byThreadClass.start();
		
	}

}
