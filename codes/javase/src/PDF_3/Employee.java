package PDF_3;

public class Employee {
	int id;
	String name;
	String surname;
	String phone;
	String address;
	int salary;
	
	public Employee() {
		
	}
	
//	public Employee(String address) {
//		
//	}
	public Employee(String name){
		System.out.println("name konstruktoru:");
		this.name=name;
		System.out.println(name);
		System.out.println("-----------");
	}
	
	public Employee(String name, String surname){
		System.out.println("name,surname konstruktoru:");
		this.name=name;
		this.surname=surname;
		System.out.println(name+" "+surname);
		System.out.println("-----------");
		
	}
	public Employee(String name, String phone, int salary){
		System.out.println("name,phone,salary konstruktoru:");
		this.name=name;
		this.phone=phone;
		this.salary=salary;
		System.out.println(name+" "+phone+" "+salary);
		System.out.println("-----------");
	}
	
}
