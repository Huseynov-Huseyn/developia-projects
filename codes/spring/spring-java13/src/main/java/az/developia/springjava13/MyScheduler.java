package az.developia.springjava13;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class MyScheduler {
//	1 saniyeden bir yazir
	@Scheduled(fixedRate = 100000)
	public void nese() {
		System.out.println("100 saniye doldu");
	}
}
