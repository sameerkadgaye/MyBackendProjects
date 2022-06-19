/**
 * 
 */
package interviewsQuestionCompanies.perfQuestions.methodOveridingConcepts;

/**
 * @author sameer
 *
 */
public class MainClassChangeDefinationWhileMethodOveriding {
	//Que from perficient : Can we change the modifier & return type of oririded class in java
	
	//Que : Can we change the scope modifier of the overridden method in the subclass?
	//Yes, an overridden method can have a different access modifier but it cannot lower the access scope.
	//Methods declared protected in a superclass must either be protected or public in subclasses; they cannot be private.
	
	//Que : Can we override a method with different return type in Java?
	//Yes. It is possible for overridden methods to have different return type .

	public static void main(String[] args) {
		ChildClass childClass = new ChildClass();
		childClass.display();     //==> Uncomment This line And Child Class Display Method To See Problem statement.
	}
}

