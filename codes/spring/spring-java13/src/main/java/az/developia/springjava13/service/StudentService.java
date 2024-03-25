package az.developia.springjava13.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import az.developia.springjava13.StudentAddResponse;
import az.developia.springjava13.entity.StudentEntity;
import az.developia.springjava13.entity.TeacherEntity;
import az.developia.springjava13.repository.StudentRepository;
import az.developia.springjava13.request.StudentAddRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
	private final StudentRepository repository;
	private final SecurityService securityService;
	private final TeacherService teacherService;

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
}