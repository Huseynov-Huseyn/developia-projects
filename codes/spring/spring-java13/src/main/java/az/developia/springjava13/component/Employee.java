package az.developia.springjava13.component;

	import org.springframework.stereotype.Component;

@Component(value = "myEmployee1")
public class Employee {
	private Integer id;
	private String name;
	private Integer age;
	private String salary;
	private Computer computer;

	public Employee() {
		this.id = 1;
		this.name = "umid";
		this.age = 20;
		this.salary = "1000$";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", computer="
				+ computer + "]";
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

}
