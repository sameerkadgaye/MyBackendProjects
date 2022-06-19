/**
 * 
 */
package thisKeyword;

/**
 * @author sameer
 *
 */
public class ExtraDemoProvingThisKeyword {

	void m() {
		System.out.println(this);// prints same reference ID
	}

	public static void main(String args[]) {
		ExtraDemoProvingThisKeyword obj = new ExtraDemoProvingThisKeyword();
		System.out.println(obj);// prints the reference ID
		obj.m();

	}
}