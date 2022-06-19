package threadNew.runAndStartConcept;

public class ThreadClass extends Thread{

	@Override
	public void run() {
		System.out.println("Inside Child Thread Named as ==>> "+currentThread().getName());
		for (int i = 0; i < 5; i++) {
			System.out.println(currentThread().getName()+" Number is = "+i);
		}
	}
}
