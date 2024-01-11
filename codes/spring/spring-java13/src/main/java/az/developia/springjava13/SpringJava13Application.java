package az.developia.springjava13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import az.developia.springjava13.component.Employee;
import az.developia.springjava13.component.Home;
import az.developia.springjava13.component.Student;

@SpringBootApplication
public class SpringJava13Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext c = SpringApplication.run(SpringJava13Application.class, args);

//		=Student studentBean = c.getBean("myStudent1", Student.class);
//		System.out.println(studentBean.getName());
//		System.out.println("----------");
//		System.out.println(studentBean.getComputer().getBrand());

//		System.out.println(studentBean.getComputer().toString());

//		Employee employeeBean = c.getBean("myEmployee2", Employee.class);
//		System.out.println(employeeBean.getName());

		Home homeBeanHome =c.getBean(Home.class);
		Home homeBeanHome2 =c.getBean(Home.class);
//		
//		String[] beanNames= c.getBeanDefinitionNames();
//		
//		for (String beanName : beanNames) {
//			System.out.println(beanName);
//		}
//
//		Person personBean = c.getBean(Person.class);
//		System.out.println(personBean.getId());
//		System.out.println("----------");
//
//		String[] beanNames2=c.getBeanDefinitionNames();
//		for (String beanName2 : beanNames2) {
//			System.out.println(beanName2);
//		}
	}

}
