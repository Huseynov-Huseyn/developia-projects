package az.developia.springjava13;

import java.util.Iterator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringJava13Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext c=SpringApplication.run(SpringJava13Application.class, args);
		
//		Student studentBean = c.getBean(Student.class);
//		System.out.println(studentBean.getName());
//		System.out.println("----------");
//
//		
//		String[] beanNames= c.getBeanDefinitionNames();
//		
//		for (String beanName : beanNames) {
//			System.out.println(beanName);
//		}
		
		Person personBean=c.getBean(Person.class);
		System.out.println(personBean.getSalary());
		System.out.println("----------");
		
		String[] beanNames2=c.getBeanDefinitionNames();
		for (String beanName2 : beanNames2) {
			System.out.println(beanName2);
		}
	}

}
