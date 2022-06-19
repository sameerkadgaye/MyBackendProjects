/**
 * 
 */
package thisKeyword;

/**
 * @author sameer
 *
 */

class A {
	A getA() {
		return this;
	}

	void msg() {
		System.out.println("Hello i am here");
	}
}

public class ThiscanReturnCurrentClassInstance {

	public static void main(String[] args) {

		new A().getA().msg();
	}

}
