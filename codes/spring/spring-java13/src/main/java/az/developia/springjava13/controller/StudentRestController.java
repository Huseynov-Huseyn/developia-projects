package az.developia.springjava13.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.dto.StudentDTO;
import az.developia.springjava13.entity.StudentEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.StudentRepository;
import az.developia.springjava13.response.StudentResponse;

@RestController
@RequestMapping(path = "/students")
public class StudentRestController {

	@Autowired
	private StudentRepository repository;

	@GetMapping

	public StudentResponse getStudents() {
		StudentResponse response = new StudentResponse();
		response.setStudents(repository.findAll());
		response.setUsername("anonim");
		return response;
	}

	@GetMapping(path = "/{id}")
	public StudentEntity findById(@PathVariable Integer id) {
		Optional<StudentEntity> o = repository.findById(id);

		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}
		if (o.isPresent()) {
			return o.get();
		} else {
			throw new OurRuntimeException(null, "bu id tapilmadi");
		}

	}

//	@RequestBody arxada avtomatik olaraq studenti component annotasiyasina baglayir
	@PostMapping(path = "/add")
	public void add(@Valid @RequestBody StudentDTO s, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "melumatlarin tamligi pozulub");
		}

		StudentEntity st = new StudentEntity();
		st.setId(null);
		st.setName(s.getName());
		st.setSurname(s.getSurname());
		st.setUsername(s.getUsername());
		st.setPassword(s.getPassword());
		repository.save(st);

	}

	@PutMapping(path = "/update")
	public void update(@Valid @RequestBody StudentDTO s, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "melumatlarin tamligi pozulub");
		}

		if (s.getId() == null || s.getId() <= 0) {
			throw new OurRuntimeException(null, "id null olmaz");
		}
		StudentEntity st = new StudentEntity();
		st.setId(s.getId());
		st.setName(s.getName());
		st.setSurname(s.getSurname());
		st.setUsername(s.getUsername());

		if (repository.findById(s.getId()).isPresent()) {
			repository.save(st);

		} else {
			throw new OurRuntimeException(null, "bu id tapilmadi");
		}

		repository.save(st);

	}

	/// student/id
	@DeleteMapping(path = "/{id}")
	public void delete(@PathVariable Integer id) {
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}

		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
		} else {
			throw new OurRuntimeException(null, "bu id tapilmadi");
		}

		repository.deleteById(id);

	}

}
