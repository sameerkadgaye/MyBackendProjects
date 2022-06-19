/**
 * 
 */
package finalAndStaticTickyQuestions.finalConcepts;

/**
 * @author sameer.kadgaye
 *
 */

//When a class is declared with final keyword, it is called a final class.
//A final class cannot be extended(inherited).
//The other use of final with classes is to create an immutable class like the predefined String class.
//You can not make a class immutable without making it final.
public final class FinalClass {

	public static void main(String[] args) {

	}

	void myFinalMethod() {
		System.out.println("My Final Method");
	}
}
