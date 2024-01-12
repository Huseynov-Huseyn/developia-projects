package az.developia.springjava13.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.component.Student;
import az.developia.springjava13.exception.OurRuntimeException;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/students")
public class StudentRestController {

	@GetMapping
	public List<String> getStudents() {
		List<String> students = new ArrayList<String>();
		students.add("Huseyn");
		students.add("Hseyn");
		students.add("eyn");
		return students;
	}

//	@RequestBody arxada avtomatik olaraq studenti component annotasiyasina baglayir
	@PostMapping
	public void add(@Valid @RequestBody Student s,BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br);
		}
		System.out.println(s);
	}

}
