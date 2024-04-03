package az.developia.springjava13;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class MyScheduler {
////	1 saniyeden bir yazir
//	@Scheduled(fixedRate = 1000)
//	public void nese() {
//		System.out.println("1 saniye doldu");
//	}
}
