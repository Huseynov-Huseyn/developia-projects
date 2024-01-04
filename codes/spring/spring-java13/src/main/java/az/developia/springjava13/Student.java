package az.developia.springjava13;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private Integer id;
	private String name;
	private String surname;
	
	public Student() {
		this.id=2;
		this.name="huseyn";
		this.surname="huseynov";
	}
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
}
