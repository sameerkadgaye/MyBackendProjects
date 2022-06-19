/**
 * 
 */

/**
 * @author SAMEER KADGAYE - Candidate
 *
 */
public class TestClass {
	public static void main(String[] args) {
		SingletonClass scc1 = SingletonClass.getInstance();
		SingletonClass scc2 = SingletonClass.getInstance();
		
		System.out.println(scc1.hashCode());
		System.out.println(scc2.hashCode());
		//or
		if (scc1 == scc2) {
			System.out.println("scc1 And scc2 Having Same Instance");
			System.out.println("Hashcode return for those two object is same");
		}
	}
}

class SingletonClass {
	
	private SingletonClass() {
	}
	public static SingletonClass singleton;
	
	//synchronized
	public static synchronized SingletonClass getInstance() {
		if(singleton == null) {
			singleton = new SingletonClass();
		}
		return singleton;
	}
}
