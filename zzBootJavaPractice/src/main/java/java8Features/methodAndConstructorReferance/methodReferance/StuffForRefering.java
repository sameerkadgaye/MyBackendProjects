/**
 * 
 */
package java8Features.methodAndConstructorReferance.methodReferance;

import java.time.LocalDate;

/**
 * @author SAMEER KADGAYE
 *
 */
public class StuffForRefering {

	public static void doStuffForReferingToAnotherSimilarStaticMethod() {
		System.out.println("I am Doing Stuff Method Implemention");
		LocalDate now = LocalDate.now();
		System.out.println(now);
	}
	
	
	public static void threadTaskForReferingToAnotherSimilarStaticMethod() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i*2);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void threadTaskForReferingToAnotherSimilarNonStaticMethod() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i*100);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
