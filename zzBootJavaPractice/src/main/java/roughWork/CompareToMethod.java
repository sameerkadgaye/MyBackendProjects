/**
 * 
 */
package roughWork;

/**
 * @author SAMEER KADGAYE
 *
 */
public class CompareToMethod {

	public static void main(String[] args) {
		String s1 = "sameer";
		String s2 = "sanket";
		String s3 = "aman";
		String s4 = "aman";
		
		System.out.println(s1.compareTo(s2));
		System.out.println(s1.compareTo(s3));
		System.out.println(s3.compareTo(s4));
		
		//Comparable interface:
	    //• Comparable meant for default natural sorting order.
		//• Comparable interface present in java.lang package and contains only one method compareTo() method.
		              //public int compareTo(Object obj);
		//Example:
		              //obj1.compareTo(obj2);
	   //• Working 
				//	|_____________ Return -ve if and only if obj1 has to come before obj2.
			    //	|
				//	|_____________ Return +ve if and only if obj1 has to come after obj2.
				//	|
				//	|_____________ Return 0(zero) if and only if obj1 and obj2 are equal.
				//  |
		
	}
}
