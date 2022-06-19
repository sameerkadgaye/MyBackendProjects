/**
 * 
 */
package thisKeyword;

/**
 * @author sameer
 *
 */
public class ThisKey1 {
	
	
	int a;
	int b;
	
	ThisKey1(int c, int d)
	{
		this.a= c;
		this.b=d;
		System.out.println("c===>"+c);
		System.out.println("d===>"+d);
		System.out.println("\n\n\n");
	}
	ThisKey1(int f, int g, int u)
	{	
		this.a=u;
		this.a= f;
		this.b= g;
		System.out.println("u===>"+u);
		System.out.println("a===>"+a);
		System.out.println("b===>"+b);
	}
	
	public static void main(String[] args) {
		
		ThisKey1 key1= new ThisKey1(10,5);
		
		//System.out.println("values are key1 ==>"+key1.a);
		
		ThisKey1 key2= new ThisKey1(10,5, 10);
		
		//System.out.println("values are key2 ==>"+key2.b);
		
		
	}

}
