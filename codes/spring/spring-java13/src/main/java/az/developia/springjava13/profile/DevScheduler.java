package az.developia.springjava13.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Profile(value = { "development" })
public class DevScheduler {

	@Scheduled(fixedRate = 2000)
	public void doIt() {
		System.out.println("development do it!");
	}
}