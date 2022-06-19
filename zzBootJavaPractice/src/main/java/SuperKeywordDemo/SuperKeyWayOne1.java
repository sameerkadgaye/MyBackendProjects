package SuperKeywordDemo;


class SuperClass
{
	
	int a=1;
	int b=2;
	
	
}
class SubClass extends SuperClass
{
	int d=10;
	SubClass(int a, int b, int c)             // Constructor la kadhich return type nahi rahu sakat.
												/*
												Constructors in Java do not return anything explicitly.
												They do not have a return type,
												not even void. However,
												as the definition of Constructor goes, it is used to initialize an object of the class. So implicitly,
												they return the current instance of the class whose constructor it is.      */
	{
		super();
		d=c;
		System.out.println("may be :-"+d);
	}
}



public class SuperKeyWayOne1
{

	public static void main(String[] args)
	{
		SubClass s1=new SubClass(10,10,10);


	}

}
