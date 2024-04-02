package az.developia.springjava13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.service.TeacherService;

@RestController
@RequestMapping(path = "/teachers")
@CrossOrigin(origins = "*")
//@Api(description = "muellimlerle bagli API-lar")
public class TeacherRestController {

	@Autowired
	private TeacherService service;

	@GetMapping
//	@PreAuthorize(value = "hasAuthority('ROLE_GET_TEACHERS')")
//	@ApiOperation(value = "Butun muellimleri qaytaran API ", notes = "Burada elave qeydler yazilir")
	public ResponseEntity<Object> getTeachers() {
		ResponseEntity<Object> findAll = service.findAll();
		return findAll;
	}

}
