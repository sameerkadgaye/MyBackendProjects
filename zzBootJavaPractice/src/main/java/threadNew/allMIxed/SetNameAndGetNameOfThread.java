/**
 * 
 */
package threadNew.allMIxed;

/**
 * @author sameer
 *
 */

//When own requirement to create class only ones then we go for Ananamous class.
//Lambda Expression Used for 'Functional Classes' for direct assignment of objector etc;

class SetNameAndGetNameOfThread {

	public static void main(String[] args) throws InterruptedException {

		// Direct Runnable Obj Access Way
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

		// Set Name Of Thread
		t1.setName("Hii Thread"); // or direct Shortcut Constructor available with parameter Thread(Runnable
									// obj,String Name).
		t2.setName("Hello Thread");

		System.out.println(t1.getName());
		System.out.println(t2.getName());

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
