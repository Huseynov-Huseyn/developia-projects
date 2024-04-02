package az.developia.springjava13;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAop {
	@Before(value = "execution (* az.developia.springjava13.service.*.find*(..))")
	public void doIt() {
		System.out.println("Tapdin");
	}
}
