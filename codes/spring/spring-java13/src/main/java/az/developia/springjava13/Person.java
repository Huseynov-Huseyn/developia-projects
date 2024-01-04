package az.developia.springjava13;

import org.springframework.stereotype.Component;

@Component
public class Person {
	private Integer id;
	private String name;
	private Integer age;
	private Integer salary;
	
	public Person() {
		this.id=10;
		this.name="huseyn";
		this.age=18;
		this.salary=10;
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

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	
}
