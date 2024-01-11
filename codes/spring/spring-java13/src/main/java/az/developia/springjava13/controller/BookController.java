package az.developia.springjava13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class BookController {
	@GetMapping(path = "/books")
	public String showBooks() {
		System.out.println("salam");
		return "books";
	}
}
