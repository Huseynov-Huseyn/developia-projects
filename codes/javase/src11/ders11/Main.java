package ders11;

public class Main {
	public static void main(String[] args) {
//		Main_Encapsulation order1 = new Main_Encapsulation();
//		order1.setName("Huseyn");
//		System.out.println(order1.getName());
//		

		Developer dev1 = new Developer(null, null, 0, null, 0);
		Developer dev2 = new Developer("huseyn", "huseynov", 18, "full", 0);
		dev1.name = "Huseyn";
		dev1.surname = "Huseynov";
		dev1.age = 18;
		dev1.salary = 0;
		dev1.department = "full-stack";

		System.out.println(dev2.salary);
		System.out.println(dev2.department);
		dev2.getInfo();
	}
}
