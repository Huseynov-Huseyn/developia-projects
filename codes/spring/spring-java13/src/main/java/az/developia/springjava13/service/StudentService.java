package az.developia.springjava13.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import az.developia.springjava13.StudentAddResponse;
import az.developia.springjava13.entity.StudentEntity;
import az.developia.springjava13.entity.TeacherEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.AuthorityRepository;
import az.developia.springjava13.repository.StudentRepository;
import az.developia.springjava13.request.StudentAddRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
	private final StudentRepository repository;
	private final SecurityService securityService;
	private final TeacherService teacherService;
	private final UserService userService;

	private final AuthorityRepository authorityRepository;

	public ResponseEntity<Object> add(StudentAddRequest dto) {

		TeacherEntity teacher = teacherService.findByUsername(securityService.findUsername());

		StudentEntity st = new StudentEntity();
		st.setId(null);
		st.setName(dto.getName());
		st.setSurname(dto.getSurname());
		st.setTeacherId(teacher.getId());

		repository.save(st);

		StudentAddResponse resp = new StudentAddResponse();
		resp.setId(null);
		resp.setName(dto.getName());
		resp.setSurname(dto.getSurname());
		resp.setBirthday(dto.getBirthday());
		resp.setEmail(dto.getEmail());

		return ResponseEntity.ok(resp);

	}

	public ResponseEntity<Object> update(StudentEntity s) {
		StudentEntity st = new StudentEntity();
		st.setId(s.getId());
		st.setName(s.getName());
		st.setSurname(s.getSurname());
		st.setUsername(s.getUsername());
		st.setTeacherId(s.getTeacherId());

		if (repository.findById(s.getId()).isPresent()) {
			repository.save(st);
		} else {
			throw new OurRuntimeException(null, "bu id tapilmadi");
		}
		repository.save(st);

		return ResponseEntity.ok(null);
	}

	public List<StudentEntity> findAll() {
		List<StudentEntity> all = repository.findAll();
		return all;
	}

	public Optional<StudentEntity> findById(Integer id) {
		Optional<StudentEntity> byId = repository.findById(id);
		return byId;
	}

	public void save(StudentEntity st) {
		repository.save(st);
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

}