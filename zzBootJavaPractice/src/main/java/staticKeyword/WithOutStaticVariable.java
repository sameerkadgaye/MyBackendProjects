package staticKeyword;

class Data1 {

	int empId;
	String name;
	String companyName;
	String companyCeo;

	public void show() {
		System.out.println("Employee Data [empId => " + empId + ", name => " + name + ", companyName =>  " + companyName
				+ ", companyCeo =>  " + companyCeo + "]");
	}

}

public class WithOutStaticVariable {

	public static void main(String[] args) {
		Data1 data1 = new Data1();
		data1.empId = 1;
		data1.name = "Sameer";
		data1.companyName = "Royals webtech";
		data1.companyCeo = "Chutiya";

		Data1 data2 = new Data1();
		data2.empId = 2;
		data2.name = "Mayank";
		data2.companyName = "Royals webtech";
		data2.companyCeo = "Maha Chutiya";

		Data1 data3 = new Data1();
		data3.empId = 3;
		data3.name = "Kalyani";
		data3.companyName = "Royals webtech";
		data3.companyCeo = "Bayankar Chutiya";
		
		System.out.println("===============================================================================");
		System.out.println("When varibale is non Static then new value is not reflect for all object \n");
		data1.show();
		data2.show();
		data3.show();
		System.out.println("===============================================================================");
		
		Data data = new Data();
		data.empId = 3;
		data.name = "Kalyani";
		data.companyName = "Royals webtech";
		Data.companyCeo= "chaman chutiya";
		//data.companyCeo= "chaman chutiya";
		if(data !=null) {
			System.out.println("\nStatic variable name accessed in different class also \n");
		}
		data.show();
		System.out.println("===============================================================================");

	}

}
