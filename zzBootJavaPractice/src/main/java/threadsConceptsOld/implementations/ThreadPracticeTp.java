/**
 * 
 */
package threadsConceptsOld.implementations;

/**
 * @author Sameer Kadgaye
 *
 */
public class ThreadPracticeTp extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread Run ====>>");
		}
	}

	public static void main(String[] args) {
		ThreadPracticeTp practiceTp = new ThreadPracticeTp();
		practiceTp.start();
	}

}
