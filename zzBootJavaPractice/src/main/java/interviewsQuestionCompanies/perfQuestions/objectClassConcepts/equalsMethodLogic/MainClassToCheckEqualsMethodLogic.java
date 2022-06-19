/**
 * 
 */
package interviewsQuestionCompanies.perfQuestions.objectClassConcepts.equalsMethodLogic;

/**
 * @author Sameer Kadgaye
 *
 */
public class MainClassToCheckEqualsMethodLogic {

	public static void main(String[] args) {
		System.out.println("Main Class To Check Equals Method Logic");

//===============================>> STARTS LOGIC FOR PRIMITIVES <<===============================//

		// IMPLEMENTATION OF OBJECT CLASS IN equals() METHOD :

		// public boolean equals(Object obj)
		// {
		// return (this == obj);
		// }

		// equals() METHOD NOT WORK WITH PRIMITIVE DATA TYPES.
		// REASON : B'coz

		// 1> Primitives Data Types Are not classes so that override equals() method
		// into primitives Data Types are Not Possible.

		// 2> In Java Every User Defined Class Has One Parent Class Named As Object
		// Class (SuperMost Class In Java). But Primitives Are Not a Classes those are
		// the keywords which is written down in java for performing specific meaning of
		// operations. So that primativeTypeVariable.equals(-i.e-); is not allowed b'coz
		// primitive is not class so that he is not support super most class(Object
		// Class)
		// properties or methods.

		// 3> primitives are keywords not a Class so that he is not support super most
		// class(Object Class) properties or methods To perform any operation on it.

		int privateTypeVariable = 10;

		// PrimitiveDataType.equals(Any Type Of Object Primitive As Well As Non
		// Primitive Also) Not Allowed primitive to equalized result it give error like
		// "Cannot invoke equals(int) on the primitive type int".
		// EXAMPLE: Uncomment line No. 51 to 57.

		System.out.println("\nOutput For Primitives Operation : ");
		System.out.println("Uncomment line No. 51 to 57 For See Output");

		// if (privateTypeVariable.equals(10)) {
		// Error Eclipse :Cannot invoke equals(int) on the primitive type int.
		// java.lang.Error: Unresolved compilation problems: Cannot invoke equals(int)
		// on the primitive type int Duplicate local variable wrapperTypeVariable
		// Duplicate local variable privateTypeVariable.
		// System.out.println("true");
		// }
//===============================>> ENDS LOGIC FOR PRIMITIVES <<==================================//		

//===============================>> STARTS LOGIC FOR NON PRIMITIVES(Wrapper Classes) <<===============================//

		// IMPLEMENTATION OF OBJECT CLASS IN equals() METHOD :

		// public boolean equals(Object obj)
		// {
		// return (this == obj);
		// }

		// equals() METHOD FINE WORK WITH NON PRIMITIVE DATA TYPES (Wrapper Classes).
		// REASON : B'coz
		
		// 1> Wrapper Classes are Class. so Internally they extends Super most Class(Object
		// Class).
		
		// 2> And Also Every Wrapper Class Has Override equals() method in Their
		// implementation of Class. For provide get Different different behavior of
		// equals() method.

		Integer wrapperTypeVariable1 = 10;
		int privateTypeVariable1 = 10;

		System.out.println("\n\nOutput For Non Primitives Operation : ");
		if (wrapperTypeVariable1.equals(10)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

		Integer integerVal = 10;
		System.out.println(integerVal.equals(10) ? "true" : "false");
		
		Boolean booleanVal = new Boolean(false);
		System.out.println(booleanVal.equals(false) ? "true" : "false");
		
		Double doubleVal = new Double(0);
		System.out.println(doubleVal.equals(0) ? "true" : "false");
		
		Float floatVal = new Float(0);
		System.out.println(floatVal.equals(0) ? "true" : "false");
		
		Byte byteVal = new Byte((byte) 0);
		System.out.println(byteVal.equals(0) ? "true" : "false");
		
		Character character = new Character('S');
		System.out.println(character.equals('S') ? "true" : "false");
		
		Short shortVal = new Short((short) 0);
		System.out.println(shortVal.equals(0) ? "true" : "false");
		
		Long longVal = new Long(0);
		System.out.println(longVal.equals(0) ? "true" : "false");
		
		
//===============================>> ENDS LOGIC FOR NON PRIMITIVES(Wrapper Classes) <<==================================//		

//=======================================>> STARTS LOGIC FOR String CLASS <<=========================================//

		// IMPLEMENTATION OF Overridden Object CLASS IN equals() METHOD IN String CLASS
		// :=>

		// public boolean equals(Object anObject) {
		// if (this == anObject) {
		// return true;
		// }
		// if (anObject instanceof String) {
		// String aString = (String)anObject;
		// if (!COMPACT_STRINGS || this.coder == aString.coder) {
		// return StringLatin1.equals(value, aString.value);
		// }
		// }
		// return false;
		// }

		// String Class Override Object Class equals Method And change Implementation as
		// equals() Method checks content comparison to Equalized Result.
		// See Below Example.

		String s1 = "sameer";
		String s2 = "sameer";
		String s3 = "sanket";
		System.out.println("\n\nOutput For String Operation : ");
		System.out.println(s1.equals(s2) ? "true" : "false");
		System.out.println(s1.equals(s3) ? "true" : "false");

//=========================================>> ENDS LOGIC FOR String CLASS <<=========================================//		

	}

}
