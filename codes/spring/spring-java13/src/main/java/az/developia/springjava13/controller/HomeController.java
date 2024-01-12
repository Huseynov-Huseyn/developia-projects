package az.developia.springjava13.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path="/home")
public class HomeController {
	@GetMapping
	public String showHome() {
		return "home";
	}

	@GetMapping(path = "/students")
	public String showStudents(@RequestParam(name = "q", required = false, defaultValue = "") String q) {
		List<String> students = new ArrayList<String>();
		students.add("Huseyn");
		students.add("Hseyn");
		students.add("eyn");

		List<String> studentsFiltered = new ArrayList<String>();
		students.stream().forEach(s -> {
			if (s.contains(q)) {
				studentsFiltered.add(s);
			}
		});
		System.out.println(studentsFiltered);

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "students";
	}


	@GetMapping(path = "/computers")
	public String showComputers() {
		return "computers";
	}
	
	
}
