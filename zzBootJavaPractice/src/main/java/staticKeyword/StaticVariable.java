package staticKeyword;

class Data {

	int empId;
	String name;
	String companyName;
	static String companyCeo;

	public void show() {
		System.out.println("Employee Data [empId => " + empId + ", name => " + name + ", companyName =>  " + companyName
				+ ", companyCeo =>  " + companyCeo + "]");
	}

}

public class StaticVariable {

	public static void main(String[] args) {
		Data data1 = new Data();
		data1.empId = 1;
		data1.name = "Sameer";
		data1.companyName = "Royals webtech";
		data1.companyCeo = "Chutiya";

		Data data2 = new Data();
		data2.empId = 2;
		data2.name = "Mayank";
		data2.companyName = "Royals webtech";
		data2.companyCeo = "Maha Chutiya";

		Data data3 = new Data();
		data3.empId = 2;
		data3.name = "Kalyani";
		data3.companyName = "Royals webtech";
		Data.companyCeo = "Bayankar Chutiya"; // other way to access static variable by name

		data1.show();
		data2.show();
		data3.show();

	}

}
