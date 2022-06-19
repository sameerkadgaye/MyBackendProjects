/**
 * 
 */
package thisKeyword;

/**
 * @author sameer
 *
 */
class Demo1 {

	int x;
	int y;

	public void demoMethode(int a) {
		System.out.println("Succesfull demoMethode(overloaded)");
	}

	public void demoMethode() {
		System.out.println("Succesfull by This keyword demoMethode(fisrt)");
		this.demoMethode(5);
	}
}

public class CurrentClassMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Demo1 demo = new Demo1();
		demo.demoMethode();
	}

}
