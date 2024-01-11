package az.developia.springjava13.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import az.developia.springjava13.component.Computer;
import az.developia.springjava13.component.Employee;
import az.developia.springjava13.component.Ram;
import az.developia.springjava13.component.Student;

@Configuration
public class MyConfig {
	@Bean
	public Student myStudent2() {
		Student s = new Student();
		s.setId(12);
		s.setName("Huseyn");
		return s;
	}

	@Bean
	public Computer myComputer2() {
		Computer c = new Computer();
		c.setId(12);
		c.setBrand("dell");
		c.setPrice(124124);
		c.setColor("Red");
		return c;
	}

	@Bean
	public Ram myRam1() {
		Ram r = new Ram();
		r.setPrice(120);
		r.setSpeed("1000MB/SEC");
		return r;
	}
	
	@Bean
	public Employee myEmployee2() {
		Employee e = new Employee();
		e.setId(12);
		e.setName("Huseyn");
		return e;
	}
}
