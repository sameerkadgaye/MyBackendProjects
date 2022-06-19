/**
 * 
 */
package innerClasses;

/**
 * @author sameer
 *
 */

/*
  Inner Class Having Three Types 
  
	  1. Member Class 
	  2. Static Class 
	  3. Anonymous Class
 */

class OuterClasss {

	String note = "Here a is a demo of Inner--->Static Inner Class";

	public void displayOuter() {
		System.out.println("This is Outer Class.");
		System.out.println(
				"Then How WE get Static Inner Class Data or creating Object for StaticInnerClass is needed or not ? \n");
	}

	static class StaticInnerClass {

		public void displayInner() {
			System.out.println(
					"Solution :- By Creating Object for Outer Class and from that object we create a new object for inner class as following \nsynatx :- \n OuterClass.InnerClass innerClassobj = outerClassobj.new InnerClass();\n");
			System.out.println("===>> Here is a Static Class Data<===");
		}

	}
}

public class StaticInnerClassDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(
				"Inner Class Having Three Types :- \n 1. Member Class \n 2. Static Class \n 3.Anonymous Class \n");

		OuterClasss outerClassobj = new OuterClasss();
		outerClassobj.displayOuter();

		// How we can access StaticInnerClass object (Yes we need object for static
		// class but way is same as the concepts of static)
		// StaticInnerClass inn = new StaticInnerClass(); //compile time error //WRONGE
		// WAY

		OuterClasss.StaticInnerClass staticInnerClassobj = new OuterClasss.StaticInnerClass(); // CORRECT WAY dont need
																								// outer
																								// class obj while
																								// creating
																								// StaticInnerClass Obj.
																								// Directly give
																								// OuterClass.StaticInnerClass();
		staticInnerClassobj.displayInner(); // and here we go for method
	}

}
