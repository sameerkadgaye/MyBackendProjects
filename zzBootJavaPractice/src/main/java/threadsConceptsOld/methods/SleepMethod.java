/*
SLEEP METHOD IN JAVA

	The sleep() method of Thread class is used to sleep a thread for the specified amount of time.

	Syntax of sleep() method in java
	The Thread class provides two methods for sleeping a thread:
	
		public static void sleep(long miliseconds)throws InterruptedException
		public static void sleep(long miliseconds, int nanos)throws InterruptedException
*/
package threadsConceptsOld.methods;

/**
 * @author Sameer Kadgaye
 *
 */
public class SleepMethod extends Thread {
	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			try {
				Thread.sleep(1500000000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		SleepMethod t1 = new SleepMethod();
		SleepMethod t2 = new SleepMethod();

		t1.start();
		t2.start();
	}
}
