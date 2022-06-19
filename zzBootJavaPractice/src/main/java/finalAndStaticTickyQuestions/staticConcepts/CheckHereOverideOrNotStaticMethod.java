/**
 * 
 */
package finalAndStaticTickyQuestions.staticConcepts;

/**
 * @author Sameer Kadgaye
 *
 */
public class CheckHereOverideOrNotStaticMethod extends ConceptStaticMethodOverideOrNot {

	// No, we cannot override static methods because method overriding is based on
	// dynamic binding at runtime and the static methods are bonded using static
	// binding at compile time. So, we cannot override static methods. The calling
	// of method depends upon the type of object that calls the static method.F
	
	
//	Can we override a static method?
	
//			No, we cannot override static methods because method overriding is based on dynamic binding at runtime and
//			the static methods are bonded using static binding at compile time. 
//			So, we cannot override static methods.
//
//			The calling of method depends upon the type of object that calls the static method. It means:
//
//			If we call a static method by using the parent class object, the original static method will be called from the parent class.
//			If we call a static method by using the child class object, the static method of the child class will be called.
//			In the following example, the ParentClass has a static method named display() and the ChildClass also has the same method signature. 
//			The method in the derived class (ChildClass) hides the method in the base class. let's see an example.

	public static void myStaticMethod() {
		System.out.println("Hello Overide Static Method");
	}

	public static void main(String[] args) {
		ConceptStaticMethodOverideOrNot conceptStaticMethodOverideOrNot = new ConceptStaticMethodOverideOrNot();
		conceptStaticMethodOverideOrNot.myStaticMethod();

		CheckHereOverideOrNotStaticMethod checkHereOverideOrNotStaticMethod = new CheckHereOverideOrNotStaticMethod();
		checkHereOverideOrNotStaticMethod.myStaticMethod();
	}

}
