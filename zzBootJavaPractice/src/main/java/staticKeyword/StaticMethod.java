package staticKeyword;

class AnotherClass {

	public static void myOwnStatic() {

		System.out.println("Huurre I dont need create Object l created successfully static method");
		// System.out.println("I just Load this class in below StaticMethod class");
	}
}

public class StaticMethod {

	public static void main(String[] args) {

		System.out.println(
				"Main Method is best example for static method we not creating any class object for accessing main method");

		// AnotherClass anotherClass = new AnotherClass();
		AnotherClass.myOwnStatic();
	}

}
