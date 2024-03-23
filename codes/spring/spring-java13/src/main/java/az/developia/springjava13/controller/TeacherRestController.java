package az.developia.springjava13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.entity.TeacherEntity;
import az.developia.springjava13.repository.TeacherRepository;
import az.developia.springjava13.response.TeacherResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/teachers")
@CrossOrigin(origins = "*")
@Api(description = "muellimlerle bagli API-lar")
public class TeacherRestController {

	@Autowired
	private TeacherRepository teacherRepository;

	@GetMapping
//	@PreAuthorize(value = "hasAuthority('ROLE_GET_TEACHERS')")
	@ApiOperation(value = "Butun muellimleri qaytaran API ", notes = "Burada elave qeydler yazilir")
	public TeacherResponse getTeachers() {
		TeacherResponse response = new TeacherResponse();
		List<TeacherEntity> list = teacherRepository.findAll();

		response.setTeachers(list);
		return response;
	}

}
