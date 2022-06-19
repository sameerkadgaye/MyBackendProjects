/**
 * 
 */
package finalAndStaticTickyQuestions.finalConcepts;

/**
 * @author sameer.kadgaye
 *
 */
public class FinalVariableAndMethodOverideOverloadConcept {
	
	public static void main(String[] args) {
		final String var = "Sameer";
		System.out.println(var.concat(" kadgaye"));
		//var = "SAMMY";
		FinalVariableAndMethodOverideOverloadConcept obj = new FinalVariableAndMethodOverideOverloadConcept();
		obj.myFinalMethod();
	}
	
	public final void myFinalMethod() {
		System.out.println("helllo sameer ");
	}
	
	public final void myFinalMethod(int a) {}   //---->> Overloading Possible in final method. 
	
												//Can We Override a Final Method?
												//No, the Methods that are declared as final 
												//cannot be Overridden or hidden. For this very reason, 
											    // a method must be declared as final only when we're sure that it is complete.
	
	

}
