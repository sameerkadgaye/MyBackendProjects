/**
 * 
 */
package threadNew.allMIxed;

/**
 * @author sameer
 *
 */

//Threads Having Three Priorities MIN_PRIORITY = 1, NORM_PRIORITY= 5, MAX_PRIORITY= 10.
//We can give priority as direct by give number 1,5,10 in setPriority() method.
//  NORM_PRIORITY= 5 is Default Priority in Thread.
class ThreadPriority {

	public static void main(String[] args) throws InterruptedException {

		// Direct Runnable Object Access Way
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hi");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
			}
		});
		// Direct Runnable Obj Access Way
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Hello");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
			}
		});

		t1.setPriority(10); //or
		//t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(1); //or
		t2.setPriority(Thread.MIN_PRIORITY);
		
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		t1.start();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
		}
		t2.start();

		t1.join(); // part of thread1 allow for execution.
		t2.join(); // Join is to Execute This thread firsts Until Don't accept another thread until
					// this not complete

		System.out.println("Bye"); // this print statement is part of main thread.

	}
}
