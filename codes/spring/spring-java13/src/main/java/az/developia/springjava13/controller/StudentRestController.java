package az.developia.springjava13.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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
import az.developia.springjava13.entity.UserEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.AuthorityRepository;
import az.developia.springjava13.repository.TeacherRepository;
import az.developia.springjava13.repository.UserRepository;
import az.developia.springjava13.request.StudentAddRequest;
import az.developia.springjava13.request.studentUpdateRequest;
import az.developia.springjava13.service.StudentService;
import az.developia.springjava13.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/students")
@Api(description = "Telebelerle bagli API-lar")
@CrossOrigin(origins = "*")
public class StudentRestController {

	@Autowired
	private StudentService service;

	@Autowired
	private UserService userService;

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	@Autowired
	private UserRepository userRepository;

//	COMPLETED
	@GetMapping
//	@PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	@ApiOperation(value = "Butun telebeleri qaytaran API ", notes = "Burada elave qeydler yazilir")
	public ResponseEntity<Object> getStudents() {

		ResponseEntity<Object> findAll = service.findAll();
		return findAll;

	}

//COMPLETED
	@GetMapping(path = "/{id}")
//	@PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	public ResponseEntity<Object> findById(@PathVariable Integer id) {

		ResponseEntity<Object> byId = service.findById(id);
		return byId;
	}

//COMPLETED
	@PostMapping(path = "/add")
	@PreAuthorize(value = "hasAuthority('ROLE_ADD_STUDENT')")
	public ResponseEntity<Object> add(@Valid @RequestBody StudentAddRequest dto, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "melumatlarin tamligi pozulub");
		}
		ResponseEntity<Object> resp = service.add(dto);

		return resp;
	}

//COMPLETED
	@PutMapping(path = "update")
	@PreAuthorize(value = "hasAuthority('ROLE_UPDATE_STUDENT')")
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
	@PreAuthorize(value = "hasAuthority('ROLE_DELETE_STUDENT')")
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		ResponseEntity<Object> res = service.delete(id);
		return res;
	}

	@PutMapping(path = "/update-me")
	@PreAuthorize(value = "hasAuthority('ROLE_UPDATE_ME')")
//	{username:'yeniUsername'}
	public void updateMe(@RequestBody StudentUpdateMeDTO req, BindingResult br) {
		String newUsername = req.getUsername();

		if (newUsername == null) {
			throw new OurRuntimeException(br, "Username boşdur");
		}

//		bu kod emeliyyati edenin username i verir
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		if (newUsername.equals(username)) {
			// throw
		}
		Optional<UserEntity> f = userService.findById(username);
		if (f.isPresent()) {
			// throw
		} else {
			userService.updateMyUsername(username, newUsername);
		}

	}

}