package az.developia.springjava13.controller;

import java.util.List;
import java.util.Optional;

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

import az.developia.springjava13.component.Student;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.StudentRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/students")
public class StudentRestController {

	@Autowired
	private StudentRepository repository;

	@GetMapping
	public List<Student> getStudents() {
		return repository.findAll();
	}

	@GetMapping(path = "/{id}")
	public Student findById(@PathVariable Integer id) {
		Optional<Student> o = repository.findById(id);

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
	public void add(@Valid @RequestBody Student s, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "melumatlarin tamligi pozulub");
		}
		s.setId(null);
		repository.save(s);
	}

	@PutMapping(path = "/update")
	public void update(@Valid @RequestBody Student s, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "melumatlarin tamligi pozulub");
		}

		if (s.getId() == null || s.getId() <= 0) {
			throw new OurRuntimeException(null, "id null olmaz");
		}

		if (repository.findById(s.getId()).isPresent()) {
			repository.save(s);
		} else {
			throw new OurRuntimeException(null, "bu id tapilmadi");
		}

		repository.save(s);
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