package threadNew.daemonThreadConcept;

public class ThreadClass extends Thread{

	@Override
	public void run() {
		String name = "";
		name += currentThread().getName()+" is Deamon Thread =>> ";
		name += currentThread().isDaemon() ? "Yes" : "No";
		System.out.println(name);
		
		for (int i = 0; i < 50; i++) {
			System.out.println(currentThread().getName()+" Number is = "+i);
		}
	}
}
