/**
 * 
 */
package threadNew.allMIxed;

/**
 * @author sameer
 *
 */

//When own requirement to create class only ones then we go for Ananamous class.

class RunnableWithAnanamousClass {

	public static void main(String[] args) {

		Runnable runnable1 = new Runnable() {
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("Hi");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
					}
				}
			}

		};
		Runnable runnable2 = new Runnable() {

			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("Hello");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
					}
				}
			}

		};

		Thread t1 = new Thread(runnable1);
		Thread t2 = new Thread(runnable2);

		t1.start();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
		}
		t2.start();
	}

}
