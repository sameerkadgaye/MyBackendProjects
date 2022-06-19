/*          
 OBJECT CLASS toString() :
 
 If We Can Not Not override toString Method In Any Pojo.
		And If we print toString() method with particular Pojo Class object then At
		 That moment it returns :

		 getClass().getName() + "@" + Integer.toHexString(hashCode());
		
		It gives implementation of toString() in Obejct Class Are As Below: 
		
		public String toString() {
        	return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }
 */
package interviewsQuestionCompanies.perfQuestions.objectClassConcepts.toStringMethodLogic;

/**
 * @author Sameer Kadgaye
 *
 */
public class TestToStringByMainMethod {

	public static void main(String[] args) {
		System.out.println("Inside Main");
		Student student = new Student(); // return =>
											// perfQuestions.objectClassConcepts.toStringMethodLogic.Student@182decdb
		System.out.println(student);
		/*
		 * 
		 * If We Can Not Not override toString Method In Any Pojo. And If we print
		 * toString() method with particular Pojo Class object then At That moment it
		 * returns :
		 * 
		 * getClass().getName() + "@" + Integer.toHexString(hashCode());
		 * 
		 * It gives implementation of toString() in Obejct Class.
		 * 
		 * public String toString() { return getClass().getName() + "@" +
		 * Integer.toHexString(hashCode()); }
		 * 
		 */

	}
}
