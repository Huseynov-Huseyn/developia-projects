package az.developia.springjava13.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component(value = "myStudent1")
@Scope(value="singleton")
//beanin her defe yenisinin yaranib yaranmamasini secir
public class Student {
	private Integer id;
	private String name;
	private String surname;
	@Autowired(required = false)
//	autowired ozumuz obyekt yaratmasaq da ozu obyekti yaradib connection edir
	@Qualifier(value = "myComputer2")
//	@Primary
	private Computer computer;

	public Student() {
		this.id = 2;
		this.name = "huseyn";
		this.surname = "huseynov";
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

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}
	@PostConstruct
	public void init() {
		System.out.println("init method");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("destroy method");
	}
}
