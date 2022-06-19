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

class RunnableWithLambdaExpression1 {

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

		t1.start();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
		}
		t2.start();
		
		t1.join(); //part of thread1 allow for execution.
		t2.join();  //Join is to Execute This thread firsts Until Don't accept another thread until this not complete
		
		System.out.println("Bye"); //this print statement is part of main thread.
		
		
	}
}
