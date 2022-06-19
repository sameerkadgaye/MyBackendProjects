/*
 What if we call run() method directly instead start() method?
 
 Answer :- 
 			1. Each thread starts in a separate call stack.
			2. Invoking the run() method from main thread, 
			   the run() method goes onto the current call stack rather than at the beginning of a new call stack.
 */
package threadsConceptsOld.questionAndAnswer;

/**
 * @author Sameer Kadgaye
 *
 */
public class CallRunMethodDirectlyInsteadOfStartMethod extends Thread{
	@Override
	public void run() {
		System.out.println("running...");
	}

	public static void main(String[] args) {
		CallRunMethodDirectlyInsteadOfStartMethod call = new CallRunMethodDirectlyInsteadOfStartMethod();
		call.run();  //possible
	}
}
