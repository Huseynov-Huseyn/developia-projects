package az.developia.springjava13.service;

import org.springframework.stereotype.Service;

@Service
public class SecurityService {
	public String findUsername() {
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return "Veli";
	}
}
