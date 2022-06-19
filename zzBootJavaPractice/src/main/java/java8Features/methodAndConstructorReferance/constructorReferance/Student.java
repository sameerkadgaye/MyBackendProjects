/**
 * 
 */
package java8Features.methodAndConstructorReferance.constructorReferance;

/**
 * @author SAMEER KADGAYE
 *
 */
public class Student {
	private String name;

	public Student() {
		System.out.println("Creating Object of Student Class");
	}
	
	public void display() {
		System.out.println("I am Student");
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
