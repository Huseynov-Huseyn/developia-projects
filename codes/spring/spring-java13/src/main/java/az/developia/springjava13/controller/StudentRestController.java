package az.developia.springjava13.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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
import az.developia.springjava13.entity.TeacherEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.AuthorityRepository;
import az.developia.springjava13.repository.StudentRepository;
import az.developia.springjava13.repository.TeacherRepository;
import az.developia.springjava13.repository.UserRepository;
import az.developia.springjava13.response.StudentResponse;

@RestController
@RequestMapping(path = "/students")
public class StudentRestController {

	@Autowired
	private StudentRepository repository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	@Autowired
	private TeacherRepository teacherRepository;

	@GetMapping
	@PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	public StudentResponse getStudents() {
		StudentResponse response = new StudentResponse();

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		TeacherEntity operatorTeacher = teacherRepository.findByUsername(username);
		Integer teacherId = operatorTeacher.getId();

		List<StudentEntity> list = repository.findAllByTeacherId(teacherId);

//		Bu olan zaman daxilindeki bir varaible gondermek olmur sadece elementi elemek olur
//		list.stream().forEach(System.out::println);

//		bu artiq asagidakin tam eynisidir
		list.stream().map(s -> {
			return s.getName();
		}).filter(s->{
			return s.contains("H");
		})
		.forEach(System.out::println);

//		for (StudentEntity student : list) {
//			System.out.println(student.getName());
//		}

		response.setStudents(list);
		response.setUsername(username);
		return response;
	}

	@GetMapping(path = "/{id}")
	@PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
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
	@PreAuthorize(value = "hasAuthority('ROLE_ADD_STUDENT')")
	public void add(@Valid @RequestBody StudentDTO s, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "melumatlarin tamligi pozulub");
		}

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		TeacherEntity operatorTeacher = teacherRepository.findByUsername(username);
		Integer teacherId = operatorTeacher.getId();

		StudentEntity st = new StudentEntity();
		st.setId(null);
		st.setName(s.getName());
		st.setSurname(s.getSurname());
		st.setTeacherId(teacherId);
		repository.save(st);

	}

	@PutMapping(path = "/update")
	@PreAuthorize(value = "hasAuthority('ROLE_UPDATE_STUDENT')")
	public void update(@Valid @RequestBody StudentEntity s, BindingResult br) {
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

		if (repository.findById(s.getId()).isPresent()) {
			repository.save(st);

		} else {
			throw new OurRuntimeException(null, "bu id tapilmadi");
		}

		repository.save(st);

	}

	/// student/id
	@DeleteMapping(path = "/{id}")
	@PreAuthorize(value = "hasAuthority('ROLE_DELETE_STUDENT')")
	public void delete(@PathVariable Integer id) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		TeacherEntity operator = teacherRepository.findByUsername(username);
		if (operator == null) {
			throw new OurRuntimeException(null, "muellim tapilmadi");
		}
		Integer teacherId = operator.getId();

		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}

		StudentEntity ent = repository.findById(id).orElseThrow(() -> new OurRuntimeException(null, "id tapilmadi "));

		if (ent.getTeacherId() == teacherId) {
			repository.deleteById(id);
			userRepository.deleteById(ent.getUsername());

			authorityRepository.deleteUserAuthorities(ent.getUsername());
		} else {

			throw new OurRuntimeException(null, "oz telebeni sil");

		}
	}
}