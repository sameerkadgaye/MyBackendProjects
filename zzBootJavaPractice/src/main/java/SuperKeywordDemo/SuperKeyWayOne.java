
/*   1)	Super is used to refer immediate parent class instance variable :-				*/

/*		We can use super keyword to access the data member or field of parent class.
		It is used if parent class and child class have same fields.								*/

package SuperKeywordDemo;

class Name
{

	String n="Sameer";
}

class SirName extends Name
{
	String n="Kadgaye";
	
	void display()
	{
		System.out.println("Name :- "+super.n);   // super class variable call
		System.out.println("Sirname :- "+n);	
	}
}


public class SuperKeyWayOne
{

	public static void main(String[] args)
	{
		SirName s1=new SirName();
		s1.display();

	}

}
