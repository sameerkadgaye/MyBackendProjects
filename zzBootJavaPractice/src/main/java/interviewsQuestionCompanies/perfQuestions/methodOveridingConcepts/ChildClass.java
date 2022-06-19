/*
 //CONCLUSION :
	//Modifier And Return type has never change in overiding only Method body will change
 */
package interviewsQuestionCompanies.perfQuestions.methodOveridingConcepts;

/**
 * @author Sameer Kadgaye
 * 		Upadted : 08-01-2022
 *
 */
public class ChildClass extends ParentClass{
	//Modifier Is Possible protected from Parent is public in child 
	@Override
	public Long chnageTypeAndModifierMethod() {
		System.out.println("My Parent Class <<==");
		return (long) 1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 //==> Uncomment This Belows Display Methods To See Problem statement.

//========================================= Start For Modifier Change Concept =======================================================//
	
//	@Override
//	private void display() {  // C.E Warning ==>  Cannot reduce the visibility of the inherited method from ParentClass
//		//super.display();
//		System.out.println("My Child Class <<==");
//	}

	
	
	//Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
    //	The method display() from the type ChildClass is not visible
	//
	//	at perficientQuestions.methodOveridingConcepts.ChangeDefinationWhileMethodOveriding.main(ChangeDefinationWhileMethodOveriding.java:13)

//========================================= End For Modifier Change Concept =======================================================//
	

//===================================== Start For Return Type Change Concept ===========================================//	
	
//	@Override
//	private String display() {  // C.E Warning ==> The return type is incompatible with ParentClass.display()
//		//super.display();
//		System.out.println("My Child Class <<==");
//		return "check";
//	}
	
//========================================= End For Return Type Change Concept ==========================================//	
	
	
	
//CONCLUSION :
	//Modifier And Return type has never change in overiding only Method body will change
}
