package az.developia.springjava13.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Profile(value = { "production" })
public class ProdScheduler {

	@Scheduled(fixedRate = 5000)
	public void doIt() {
		System.out.println("production do it!");
	}
}
