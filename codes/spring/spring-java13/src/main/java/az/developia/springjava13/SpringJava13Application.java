package az.developia.springjava13;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJava13Application {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper obj = new ModelMapper();
		return obj;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext c = SpringApplication.run(SpringJava13Application.class, args);

		System.out.println("---------------------");
		System.out.println("Everything is OK!,sir");
		System.out.println("---------------------");

//		Student studentBean = c.getBean("myStudent1", Student.class);
//		System.out.println(studentBean.getName());
//		System.out.println("----------");
//		System.out.println(studentBean.getComputer().getBrand());

//		Home homeBeanHome = c.getBean(Home.class);
//		Home homeBeanHome2 = c.getBean(Home.class);
//		
	}
}
