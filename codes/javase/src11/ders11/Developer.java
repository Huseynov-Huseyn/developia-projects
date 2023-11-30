package ders11;

public class Developer extends Person{
	int salary;
	String department;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Developer(String name,String surname,int age, String department, int salary) {
		super(name,surname,age);
		this.department=department;
		this.salary=salary;
	}
	
	@Override
	public void getInfo() {
		super.getInfo();
		System.out.println("Salary:"+ salary);
		System.out.println("department:"+ department);
	}
	
}
