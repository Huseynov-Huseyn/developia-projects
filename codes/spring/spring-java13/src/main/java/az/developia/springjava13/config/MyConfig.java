package az.developia.springjava13.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import az.developia.springjava13.Student;

@Configuration
public class MyConfig {
	@Bean
	public Student myStudent() {
		Student s=new Student();
		s.setId(12);
		s.setName("Huseyn");
		return s;
	}
		
}
