/**
 * 
 */
package singletonClassInJava;

/**
 * @author SAMEER KADGAYE
 *
 */
public class MySingletonPojoClass {

	private MySingletonPojoClass() {
	}
	
	private static MySingletonPojoClass mySingletonPojoClass = null;
	
	public static MySingletonPojoClass getInstance() {
		if(mySingletonPojoClass== null)
			mySingletonPojoClass = new MySingletonPojoClass();
		return mySingletonPojoClass;
	}

}
