package SuperKeywordDemo;

/*		    2) super can be used to invoke parent class method :-
			
			The super keyword can also be used to invoke parent class method.
			It should be used if subclass contains the same method as parent class.
			In other words, it is used if method is overridden.    
*/


class MyClass5
{
	void set()
	{
		System.out.println("First statements");
	}
}

class MyClass6 extends MyClass5
{
	void set()
	{	
		super.set(); 				// invoke karu sakto parent class chya method la dusrya class madhe
		System.out.println("Upadated First Statements");
	}
}



public class SuperKeySecondWay
{

	public static void main(String[] args)
	{
		
		MyClass6 m1=new MyClass6();
		m1.set();
	}

}
