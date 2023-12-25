package az.developia.springjava13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//component scan
//auto config	
//config
@SpringBootApplication
public class SpringJava13Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext c = SpringApplication.run(SpringJava13Application.class, args);

		Student studentBean = c.getBean(Student.class);
		System.out.println(studentBean.getName());
		System.out.println("----------");
		
		Book bookBean = c.getBean(Book.class);
		System.out.println(bookBean.getId());
		System.out.println(bookBean.getName());
		System.out.println(bookBean.getPrice());
		System.out.println(bookBean.getPageCount());
		System.out.println("----------");
		
		Person personBean = c.getBean(Person.class);
		System.out.println(personBean.getId());
		System.out.println(personBean.getName());
		System.out.println(personBean.getAge());
		System.out.println(personBean.getSalary());
		System.out.println("----------");
		
		String[] beanNames=c.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
}