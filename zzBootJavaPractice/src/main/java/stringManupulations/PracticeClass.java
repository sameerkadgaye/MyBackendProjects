/**
 * 
 */
package stringManupulations;

/**
 * @author sameer
 *
 */
final class PracticeClass {

	/**
	 * 
	 */
	private int i;

	public PracticeClass(int i) {
		this.i = i;
	}

	public PracticeClass modify(int i) {

		if (this.i == i) {
			return this;
		} else {
			return new PracticeClass(i);
		}
	}

	public static void main(String[] args) {

		/*
		 * String s = new String("sameer"); s.concat("kadgaye");
		 * System.out.println("Output ==========>>>  " + s);
		 */
		/*
		 * StringBuffer s = new StringBuffer("sameer"); StringBuffer s1 = new
		 * StringBuffer("sameer"); // s1 = s; System.out.println(s == s1);
		 * System.out.println(s.equals(s1));
		 */

		/* String s1 = new String("summer"); */
		/*
		 * s1.concat("spring"); System.out.println(s1);
		 * 
		 * String s2 = s1.concat("spring"); System.out.println("valid =====>>>" + s2);
		 */
		/*
		 * String s2 = s1 + "sameer"; System.out.println(s2);
		 */

		/*
		 * s1="fghj"; System.out.println(s1);
		 */
		/* PracticeClass t1 = new PracticeClass(10); */

		PracticeClass p1 = new PracticeClass(10);
		PracticeClass p2 = p1.modify(100);
		PracticeClass p3 = p1.modify(10);
		System.out.println(p1 == p2);
		System.out.println(p1 == p3);

	}
}
