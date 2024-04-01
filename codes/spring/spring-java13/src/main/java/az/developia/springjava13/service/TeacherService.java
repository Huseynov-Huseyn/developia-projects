package az.developia.springjava13.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import az.developia.springjava13.entity.TeacherEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.TeacherRepository;
import az.developia.springjava13.response.TeacherResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherService {

	private final TeacherRepository repository;
	private final SecurityService securityService;

	public TeacherEntity findByUsername(String username) {
		TeacherEntity t = repository.findByUsername(username);
		if (t == null) {
			throw new OurRuntimeException(null, "muellim tapilmadi");
		}
		return t;
	}

	public ResponseEntity<Object> findAll() {
		TeacherResponse response = new TeacherResponse();
		List<TeacherEntity> list = repository.findAll();

		response.setTeachers(list);
		response.setUsername(securityService.findUsername());

		return ResponseEntity.ok(response);

	}
}