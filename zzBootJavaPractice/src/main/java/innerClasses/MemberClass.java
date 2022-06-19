/**
 * 
 */
package innerClasses;

/**
 * @author sameer
 *
 */

/*
 * Inner Class Having Three Types 1. Member Class 2. Static Class 3.Anonymous
 * Class
 */

class OuterClass {

	String note = "Here a is a demo of Inner--->Member Class";

	public void displayOuter() {
		System.out.println("This is Outer Class.");
		System.out.println("Then How WE get Inner Class Data or How we create Object for InnerClass..? \n");
	}

	class InnerClass {

		public void displayInner() {
			System.out.println(
					"By Creating Object for Outer Class and from that object we create a new object for inner class as following \nsynatx :- \n OuterClass.InnerClass innerClassobj = outerClassobj.new InnerClass();\n");
			System.out.println("===>> Here is a Member Class <===");
		}

	}
}

public class MemberClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(
				"Inner Class Having THree Types :- \n 1. Member Class \n 2. Static Class \n 3.Anonymous Class \n");

		OuterClass outerClassobj = new OuterClass();
		outerClassobj.displayOuter();

		// How we can access InnerClass object
		// InnerClass inn = new InnerClass(); //compile time error //WRONGE WAY
		OuterClass.InnerClass innerClassobj = outerClassobj.new InnerClass(); // CORRECT WAY
		innerClassobj.displayInner(); // and here we go for method
	}

}
