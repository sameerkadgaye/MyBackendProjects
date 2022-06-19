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
public class Student {

	/**
	 * 
	 */
	public Student() {
	}

	String fname = "sameer";
	String lname = "kadgaye";

}
