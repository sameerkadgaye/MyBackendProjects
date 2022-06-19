/**
 * @author Interviewer Answer Regarding Singleton Question.
 *
 */
import java.io.*;
public class TestClassIntervieweAnswered {
	private static TestClass myTestClass;
	static {
		myTestClass = new TestClassIntervieweAnswered();
	}
	private TestClassIntervieweAnswered() {
	}
	public static TestClass getIntance() {
		if(myTestClass == null) {
			synchronized(TestClassIntervieweAnswered.class) {
				if(myTestClass == null) {
					myTestClass = new TestClassIntervieweAnswered();
				}
			}
		}
		return myTestClass;
	}
	public void testMe() {
		System.out.println("Hey I am Singleton");
	}
	public static void main(String[] args) {
		//Read input from STDIN; Write output to STDOUT.
		TestClass tc = getIntance();
		tc.testMe();
	}
}
