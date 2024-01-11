package az.developia.springjava13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
	@GetMapping(path = "/employee")
	public String showEmployee() {
		return "employee";
	}

}
