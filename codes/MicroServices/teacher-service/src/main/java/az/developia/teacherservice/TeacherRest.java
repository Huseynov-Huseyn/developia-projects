
package az.developia.teacherservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/teachers")
@CrossOrigin(origins = "*")
public class TeacherRest {

	@Autowired
	private TeacherRepository repository;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping
	public TeacherListResponse findAll() {

		TeacherListResponse response = new TeacherListResponse();

		List<TeacherEntity> entities = repository.findAll();

		response.setTeachers(entities);

		return response;

	}

	@GetMapping(path = "/with-students")
	public TeacherListResponse findAllWithStudents() {

		TeacherListResponse response = new TeacherListResponse();
		List<TeacherResp> teachersWithStudents = new ArrayList<>();

		List<TeacherEntity> entities = repository.findAll();

		for (TeacherEntity teacherEntity : entities) {
			TeacherResp dto = new TeacherResp();
			dto.setId(teacherEntity.getId());
			dto.setName(teacherEntity.getName());

			StudentListResponse resp = restTemplate.getForObject(
					"http://student-service/students/teacher/" + teacherEntity.getId(), StudentListResponse.class);

			dto.setStudents(resp.getStudents());
			teachersWithStudents.add(dto);
		}

		response.setTeachersWithStudents(teachersWithStudents);

		return response;

	}

}
