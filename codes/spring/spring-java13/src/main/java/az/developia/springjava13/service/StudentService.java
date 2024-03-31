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
import az.developia.springjava13.request.studentUpdateRequest;
import az.developia.springjava13.response.StudentResponse;
import jakarta.validation.Valid;
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

	public ResponseEntity<Object> update(@Valid studentUpdateRequest s) {
		Optional<StudentEntity> id = repository.findById(s.getId());

		StudentEntity se = id.get();
		repository.findById(s.getId()).ifPresentOrElse((a -> repository.save(se)),
				() -> new OurRuntimeException(null, "id tapilmadi"));
		return ResponseEntity.ok("tələbə yeniləndi");
	}

	public ResponseEntity<Object> findAll() {
		StudentResponse response = new StudentResponse();
		List<StudentEntity> lis = repository.findAll();
		response.setStudents(lis);
		response.setUsername(securityService.findUsername());

		return ResponseEntity.ok(response);
	}
}