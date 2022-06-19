package thisKeyword;

class Student1
{  
int rollno;  
String name;  
float fee;  
	Student1(int r,String n,float f)
	{  
		rollno=r;  
		name=n;  
		fee=f;  
	} 
	void display()
	{
		System.out.println(rollno+" "+name+" "+fee);}  
	}  

public class ProgramWhereThisKeyNotRequired {

	public static void main(String[] args) 
	{
		Student1 s1=new Student1(111,"sameer",5000f);  
		Student1 s2=new Student1(112,"sumit",6000f);  
		s1.display();  
		s2.display();  
	}
	
}
