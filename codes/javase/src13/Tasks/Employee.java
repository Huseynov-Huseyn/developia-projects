package Tasks;

public class Employee extends Person {
	int salary;
	String deparment;
	String username;
	String password;

	public Employee(int id, String name, String surname, int age, String phone, String address, int salary,
			String deparment, String username, String password) {
		super(id, name, surname, age, phone, address);
		this.salary = salary;
		this.deparment = deparment;
		this.username = username;
		this.password = password;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDeparment() {
		return deparment;
	}

	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void printInfo() {
		super.prinInfo();
		System.out.println("salary:" + salary);
		System.out.println("deparment:" + deparment);
		System.out.println("username:" + username);
		System.out.println("password:" + password);
	}
}
