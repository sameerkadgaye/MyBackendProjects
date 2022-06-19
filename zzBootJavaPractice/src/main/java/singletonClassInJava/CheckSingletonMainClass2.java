/**
 * 
 */
package singletonClassInJava;

/**
 * @author SAMEER KADGAYE
 *
 */
public class CheckSingletonMainClass2 {

	public static void main(String[] args) {
		MySingletonPojoClass mySingletonPojoClass = MySingletonPojoClass.getInstance();
		MySingletonPojoClass mySingletonPojoClass1 = MySingletonPojoClass.getInstance();
		MySingletonPojoClass mySingletonPojoClass2 = MySingletonPojoClass.getInstance();
		MySingletonPojoClass mySingletonPojoClass3 = MySingletonPojoClass.getInstance();
		System.out.println(mySingletonPojoClass.hashCode());
		System.out.println(mySingletonPojoClass1.hashCode());
		System.out.println(mySingletonPojoClass2.hashCode());
		System.out.println(mySingletonPojoClass3.hashCode());
	}

}
//o/p :
//123961122
//123961122
//123961122
//123961122