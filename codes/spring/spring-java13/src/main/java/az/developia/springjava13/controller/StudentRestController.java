package az.developia.springjava13.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.dto.StudentUpdateMeDTO;
import az.developia.springjava13.entity.StudentEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.filtering.DynamicFilteringDemo;
import az.developia.springjava13.repository.StudentRepository;
import az.developia.springjava13.request.StudentAddRequest;
import az.developia.springjava13.request.studentUpdateRequest;
import az.developia.springjava13.response.StudentListResponse;
import az.developia.springjava13.service.StudentService;
import az.developia.springjava13.service.UserService;

@RestController
@RequestMapping(path = "/students")
//@Api(description = "Telebelerle bagli API-lar")
@CrossOrigin(origins = "*")
public class StudentRestController {

	@Autowired
	private StudentService service;

	@Autowired
	private StudentRepository repository;

	@Autowired
	private UserService userService;

	@Autowired
	private DynamicFilteringDemo dynamic;

	private Logger logger = LoggerFactory.getLogger(StudentRestController.class);

//	@Autowired
//	private ViewRepository viewRepository;

//	COMPLETED
	@GetMapping
//	@PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
//	@ApiOperation(value = "Butun telebeleri qaytaran API ", notes = "Burada elave qeydler yazilir")
	public StudentListResponse getStudents() {
		if (service.getStudents() == null) {
			StudentListResponse response = new StudentListResponse();
			List<StudentEntity> entities = repository.findAll();
			response.setStudents(service.convertEntitiesToDtos(entities));
			service.setStudents(response);
		}
		return service.getStudents();
	}

//COMPLETED
	@GetMapping(path = "/{id}", produces = { "application/json", "application/xml" })
//	@PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	public ResponseEntity<Object> findById(@PathVariable Integer id) {

		ResponseEntity<Object> byId = service.findById(id);
		return byId;
	}

//COMPLETED
//	@PostMapping(path = "/add", produces = { "application/json", "application/xml" })
	@PostMapping
//	@PreAuthorize(value = "hasAuthority('ROLE_ADD_STUDENT')")
	public ResponseEntity<Object> add(@Valid @RequestBody StudentAddRequest dto, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "melumatlarin tamligi pozulub");
		}
		ResponseEntity<Object> resp = service.add(dto);
		logger.debug(" student add - " + dto);
		return resp;
	}

//COMPLETED
	@PutMapping(path = "/update")
//	@PreAuthorize(value = "hasAuthority('ROLE_UPDATE_STUDENT')")
	public ResponseEntity<Object> update(@Valid @RequestBody studentUpdateRequest s, BindingResult br) {

		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "melumatlarin tamligi pozulub");
		}

		ResponseEntity<Object> res = service.update(s);
		return res;

	}

	// COMPLETED
	/// student/id
	@DeleteMapping(path = "/{id}")
//	@PreAuthorize(value = "hasAuthority('ROLE_DELETE_STUDENT')")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		ResponseEntity<Object> res = service.delete(id);
		return res;
	}

	@PutMapping(path = "/update-me")
//	@PreAuthorize(value = "hasAuthority('ROLE_UPDATE_ME')")
//	{username:'yeniUsername'}
	public void updateMe(@RequestBody StudentUpdateMeDTO req, BindingResult br) {
		String newUsername = req.getUsername();

		if (newUsername == null) {
			throw new OurRuntimeException(br, "Username boşdur");
		}

//		bu kod emeliyyati edenin username i verir
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();

//		if (newUsername.equals(username)) {
		// throw
//		}
//		Optional<UserEntity> f = userService.findById(username);
//		if (f.isPresent()) {
//			// throw
//		} else {
//			userService.updateMyUsername(username, newUsername);
//		}

	}

//	PAGGINATION DERSI 38
//	/students/pagination/begin/3/length/5
	@GetMapping(path = "/pagination/begin/{begin}/length/{length}")
//	@PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	public ResponseEntity<Object> findPagination(@PathVariable Integer begin, @PathVariable Integer length) {
		if (length > 100) {
			throw new OurRuntimeException(null, "uzunluq 100den cox ola bilmez");
		}
		ResponseEntity<Object> pagination = service.findPaginationMethod(begin, length);

		return pagination;
	}

	@GetMapping(path = "/id-name")
//	@PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	public MappingJacksonValue getStudentIdName() {
		StudentListResponse response = new StudentListResponse();
		List<StudentEntity> entities = repository.findAll();
		response.setStudents(service.convertEntitiesToDtos(entities));

		return dynamic.filter("student", response, "id", "name");
	}

	@GetMapping(path = "/id-username")
//	@PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	public MappingJacksonValue getStudentIdUsername() {
		StudentListResponse response = new StudentListResponse();

		List<StudentEntity> entities = repository.findAll();
		response.setStudents(service.convertEntitiesToDtos(entities));

		return dynamic.filter("student", response, "id", "username", "birthday");
	}

	private StudentListResponse students;
}