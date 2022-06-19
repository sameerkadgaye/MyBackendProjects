/**
 * 
 */
package threadNew.allMIxed;

/**
 * @author sameer
 *
 */
class Counter1 {

	int count;

	public synchronized void increment() {
		count++; // count = count +1;
	}
}

public class WithSynchronizedMethod {

	public static void main(String[] args) throws Exception {

		Counter1 counter = new Counter1();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					counter.increment();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					counter.increment();
				}
			}
		});
		t1.start(); // part of Thread t1
		t2.start(); // part of Thread t2

		t1.join();
		t2.join();

		System.out.println("Count ==>> " + counter.count); // part of Main Thread. //What expected Output is 2000.

		// But every time we got different output. B'coz At a time three threads working
		// simultaneously for different different purposed.
		// Form them Two Threads are trying to get increment() method at a time. and
		// Hence this this problem arise.
		// Two solve This we need two create increment() method as a synchronized, then
		// at time only one method can allow to take operation from increment() method
		// once that thread not completing there work then until other thread are not
		// allow to access increment method (they are wait state).

	}

}
