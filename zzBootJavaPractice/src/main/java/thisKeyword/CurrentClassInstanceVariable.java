/**
 * 
 */
package thisKeyword;

/**
 * @author sameer
 *
 */

class Demo {

	int x;
	int y;

	Demo(int x, int y) {
		this.x = x;
		this.y = y;

	}
}

public class CurrentClassInstanceVariable {

	public static void main(String kuchBhi[]) {

		Demo demo = new Demo(10, 10);
		System.out.println(demo.x);
		System.out.println(demo.y);
	}

}
