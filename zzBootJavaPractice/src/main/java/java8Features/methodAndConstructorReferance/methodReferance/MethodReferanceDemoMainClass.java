/**
 * 
 */
package java8Features.methodAndConstructorReferance.methodReferance;

/**
 * @author SAMEER KADGAYE
 *
 */
public class MethodReferanceDemoMainClass {
	
	public static void forStaticMethodReferanceExample() {
		//--------------------------------------------------------------1Starts----------------------------------------------------------------------//
			//Yat apan static method Refer Kel Ahe
			//syntax ClassName::staticMethodNameAssosiatedWithGivenClass
			WorkOnThatMethodProviderInterfaceForMethodRef refInterfaceMethod = StuffForRefering :: doStuffForReferingToAnotherSimilarStaticMethod; 
														//Yat apan StuffForRefering Class madhe asnarya doStuffForReferingToAnotherSimilarStaticMethod() static method chi
														//Body i.e (arguments){...} hi refer keli WorkOnThatMethodProviderInterfaceForMethodRef Interface
														//Chya doTask method la.
			refInterfaceMethod.doTask();
		//---------------------------------------------------------------1Ends----------------------------------------------------------------------//
				
		//--------------------------------------------------------------2Starts---------------------------------------------------------------------//
				Runnable runnable= StuffForRefering :: threadTaskForReferingToAnotherSimilarStaticMethod;
														//Yat apan StuffForRefering Class madhe asnarya threadTaskForReferingToAnotherSimilarStaticMethod() static method chi
														//Body i.e (arguments){...} hi refer keli runnable Interface
														//Chya doTask method la.
				new Thread(runnable).start();
	    //--------------------------------------------------------------2Ends-----------------------------------------------------------------------//
	}
	
	public static void forNonStaticMethodReferanceExample() {
		//For Non Staic method madhe method Refer kartana Tya perticular class cha object dya lagto jyachi method apan refer karat ahot
		//i.e new Object():: anyNoStaticMethodNameAssosiatedWithGivenObjectClass
		//--------------------------------------------------------------2Starts---------------------------------------------------------------------//
		  		Runnable runnable= new StuffForRefering() :: threadTaskForReferingToAnotherSimilarNonStaticMethod;
												     	//Yat apan StuffForRefering Class madhe asnarya threadTaskForReferingToAnotherSimilarNonStaticMethod() static method chi
														//Body i.e (arguments){...} hi refer keli runnable Interface
														//Chya doTask method la.
		  		new Thread(runnable).start();
		//--------------------------------------------------------------2Ends-----------------------------------------------------------------------//
	}
	
	public static void main(String[] args) {
		System.out.println("<<<======= Leaning Method Reference Starts =======>>>");
		forStaticMethodReferanceExample();
		forNonStaticMethodReferanceExample();
		
		System.out.println("<<<======= Leaning Method Reference Ends =======>>>");
	}

	//Rules For Method Reference.
	//1> Method argumets must same he same pahije jya method la apan refer karat aho tyache with jyat apan refer kararnar ahot tya sobal (Manje dognche args same pahije)
	//   i.e doStuffForReference(argsSameNeeded)  And catchRefercedStuff(argsSameNeeded)

	//2> Return Type Different rahal tari chalto.
}
