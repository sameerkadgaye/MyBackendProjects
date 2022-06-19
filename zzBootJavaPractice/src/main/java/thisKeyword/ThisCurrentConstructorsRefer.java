//  1) this: to refer current class instance variable  :-

/*     The this keyword can be used to refer current class instance variable. 
	   If there is ambiguity between the instance variables and parameters, 
	   this keyword resolves the problem of ambiguity.		*/

package thisKeyword;

public class ThisCurrentConstructorsRefer
{
	int a;
	int b;
	
	ThisCurrentConstructorsRefer()
	{	
		this(10,10);
	System.out.println("This parameter less constructor.");
	}
	
	ThisCurrentConstructorsRefer(int a, int b)
	{
		//this();
		this.a=a;
		this.b=b;
		System.out.println(a*b);
	}
	
	ThisCurrentConstructorsRefer(int a, int b, int c)
	{	
		this(a,b);
		int s=b-a;
		System.out.println( "Constructor with 3 parameter :- \t"+s );
		
		 this.a=a; this.b=b; a=c;
		 int k= a+b+c;
		 System.out.println("This answer of adition :- \t"+k);
		
	}
	
	/*
	 * void set(int a, int b) { this.a=a; this.b=b; }
	 */
	/*
	 * void display(int a,int b,int c) { this.a=a; this.b=b; int d=10; d=c; int
	 * t=a+b+c; System.out.println("Method :-\t"+t); }
	 */
	
	public static void main(String[] args) 
	{
		ThisCurrentConstructorsRefer b1=new ThisCurrentConstructorsRefer();
		ThisCurrentConstructorsRefer a1=new ThisCurrentConstructorsRefer(10,20,30);
		//ThisCurrentRefer1 a2=new ThisCurrentRefer1(10,20);
		//ThisCurrentRefer1 a3=new ThisCurrentRefer1();
		//a3.display(10, 10, 10);
	}

}
