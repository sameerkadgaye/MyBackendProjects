/*
 //CONCLUSION :
	//Modifier And Return type has never change in overiding only Method body will change
 
 */
package interviewsQuestionCompanies.perfQuestions.methodOveridingConcepts;

/**
 * @author Sameer Kadgaye
 *
 */
public class ParentClass {
	
	public void display() {
		System.out.println("My Parent Class <<==");
	}
	
	protected Long chnageTypeAndModifierMethod() {
		System.out.println("My Parent Class <<==");
		return (long) 1;
	}

}
//CONCLUSION :
	//Modifier And Return type has never change in overiding only Method body will change