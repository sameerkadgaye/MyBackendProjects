/*
3) super is used to invoke parent class constructor :-

Note: super() is added in each class constructor automatically by compiler if there is no super() or this().

*/

/*
  	As we know well that default constructor is provided by compiler automatically if there is no constructor.
  	But, it also adds super() as the first statement.*/
  	
  	
/*  	Another example of super keyword where super() is provided by the compiler implicitly.
  	
 */


package SuperKeywordDemo;

class Cat1
{
	Cat1()
	{
		System.out.println("mauoow mauooow mauoooow");
	}
}

class Dog1 extends Cat1
{
	Dog1()
	{	
	// yaa madhe automatically added aslela super key. ha invoke karto Super or parent class chya constructor la.
	//Another example of super keyword where super() is provided by the compiler implicitly.		
		System.out.println("bouooo bouooo bouooo");
	}
}

public class SuperKeyThirdWay1
{

	public static void main(String[] args)
	{
		Dog1 s1=new Dog1();
		
	}

}
