/**
 * 
 */
package thisKeyword;

/**
 * @author sameer
 *
 */

class B {
	PassAsArgumentInTheConstructorCall obj;

	B(PassAsArgumentInTheConstructorCall obj) {
		this.obj = obj;
	}

	void display() {
		System.out.println(obj.data);// using data member of PassAsArgumentInTheConstructorCall class
	}
}

public class PassAsArgumentInTheConstructorCall {

	int data = 10;

	PassAsArgumentInTheConstructorCall() {
		B b = new B(this); // creating object of above B class and passing this class argument in that.
		b.display();
	}

	public static void main(String args[]) {
		PassAsArgumentInTheConstructorCall a = new PassAsArgumentInTheConstructorCall();
	}

}
