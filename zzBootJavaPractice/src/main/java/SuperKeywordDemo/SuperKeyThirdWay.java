/*
3) super is used to invoke parent class constructor :-

Note: super() is added in each class constructor automatically by compiler if there is no super() or this().

*/

package SuperKeywordDemo;

class Cat
{
	Cat()
	{
		System.out.println("mauoow mauooow mauoooow");
	}
}

class Dog extends Cat
{
	Dog()
	{	
		super();				// invoke karo Super or parent class chya constructor la.
		System.out.println("bouooo bouooo bouooo");
	}
}

public class SuperKeyThirdWay
{

	public static void main(String[] args)
	{
		Dog s1=new Dog();
		
	}

}
