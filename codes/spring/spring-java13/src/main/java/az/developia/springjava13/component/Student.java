package az.developia.springjava13.component;

import jakarta.validation.constraints.Size;

public class Student {
	private Integer id;
	@Size(min=2,max=40,message = "Ad min 2 max 40 ola biler")
	private String name;
	private String surname;
	
	
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", surname=" + surname + "]";
	}

}
