package az.developia.studentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.studentservice.entity.StudentEntity;
import az.developia.studentservice.repository.StudentRepository;
import az.developia.studentservice.response.StudentListResponse;

@RestController
@RequestMapping(path = "/students")
@CrossOrigin(origins = "*")
public class StudentRest {

	@Autowired
	private StudentRepository repository;

	@GetMapping(path = "/teacher/{teacherId}")
	public StudentListResponse findAllByTeacherId(@PathVariable Integer teacherId) {

		StudentListResponse response = new StudentListResponse();

		List<StudentEntity> entities = repository.findAllByTeacherId(teacherId);

		response.setStudents(entities);

		return response;

	}
}
