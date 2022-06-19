package java8Features.methodAndConstructorReferance.constructorReferance;

/**
 * @author SAMEER KADGAYE
 *
 */
public class ConstructorReferanceDemoMainClass {

	private static void forconstructorReferanceExample() {
		//Constructor Reference
		//Classname ::new
		WorkOnThatConstructorProviderInterfaceForConstructorRef provider = Student::new;
		Student student = provider.getStudent();
		student.display();
	}
	
	public static void main(String[] args) {
		System.out.println("<<<======= Leaning Constructor Reference Starts =======>>>");
		forconstructorReferanceExample();
//		forNonStaticMethodReferanceExample();
		
		System.out.println("<<<=======  Leaning Constructor Reference Ends  =======>>>");
	}
	
}
