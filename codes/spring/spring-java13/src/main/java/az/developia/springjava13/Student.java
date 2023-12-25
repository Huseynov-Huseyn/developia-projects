package az.developia.springjava13;

import org.springframework.stereotype.Component;

@Component (value="telebem")
public class Student{
	private Integer id;
	private String name;
	public Student() {
		super();
		this.id = 2;
		this.name = "Huseyn";
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
	
	
}