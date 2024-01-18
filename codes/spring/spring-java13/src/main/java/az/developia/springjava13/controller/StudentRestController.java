package az.developia.springjava13.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private DataSource dataSource;

	@GetMapping
	public List<String> getStudents() {
		List<String> students = new ArrayList<String>();
		students.add("Huseyn");
		students.add("Hseyn");
		students.add("eyn");
		return students;
	}

//	@RequestBody arxada avtomatik olaraq studenti component annotasiyasina baglayir
	@PostMapping(path = "/add")
	public void add(@Valid @RequestBody Student s, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br);
		}
		System.out.println(s);
//		s obyektini bazaya gonder
		try {
			Connection conn = dataSource.getConnection();
			java.sql.Statement st = conn.createStatement();
			st.executeUpdate(
					"insert into students (name,surname) values('" + s.getName() + "','" + s.getSurname() + "');");
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
