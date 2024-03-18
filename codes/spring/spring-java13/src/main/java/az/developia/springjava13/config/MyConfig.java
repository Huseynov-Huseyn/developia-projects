package az.developia.springjava13.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import az.developia.springjava13.entity.StudentEntity;

@Configuration
public class MyConfig {
	@Bean
	public StudentEntity myStudent2() {
		StudentEntity s = new StudentEntity();
		s.setId(12);
		s.setName("Huseyn");
		return s;
	}

}
