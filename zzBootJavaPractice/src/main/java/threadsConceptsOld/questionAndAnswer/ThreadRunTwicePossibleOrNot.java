/*
Can we start a thread twice  .?

Answer :- No. After starting a thread, it can never be started again.
 		  If you does so, an IllegalThreadStateException is thrown. In such case, 
		  thread will run once but for second time, it will throw exception.
 */
package threadsConceptsOld.questionAndAnswer;

/**
 * @author Sameer Kadgaye
 *
 */
public class ThreadRunTwicePossibleOrNot extends Thread {

	@Override
	public void run() {
		System.out.println("Running ......!!");
	}

	public static void main(String[] args) {
		ThreadRunTwicePossibleOrNot not = new ThreadRunTwicePossibleOrNot();
		not.start();
		not.start();  //java.lang.IllegalThreadStateException On Runtime.
	}

}
