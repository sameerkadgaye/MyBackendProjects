/*
THE JOIN() METHOD 
 
	The join() method waits for a thread to die. In other words, 
	it causes the currently running threads to stop executing until the thread it joins with completes its task.
	
	Syntax:
			public void join()throws InterruptedException
			public void join(long milliseconds)throws InterruptedException
 */
package threadsConceptsOld.methods;

/**
 * @author Sameer Kadgaye
 *
 */
public class JoinMethod extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		JoinMethod t1 = new JoinMethod();
		JoinMethod t2 = new JoinMethod();
		JoinMethod t3 = new JoinMethod();

		t1.start();
		try {
			t1.join();
		} catch (Exception e) {
			System.out.println(e);
		}

		t2.start();
//		try {
//			t2.join();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		t3.start();
	}
}




//	Output:1
//	2
//	3
//	4
//	5
//	1
//	1
//	2
//	2
//	3
//	3
//	4
//	4
//	5
//	5

//  As you can see in the above example,when t1 completes its task then t2 and t3 starts executing.