package az.developia.springjava13.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import az.developia.springjava13.entity.StudentEntity;
import az.developia.springjava13.entity.TeacherEntity;
import az.developia.springjava13.entity.UserEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.request.StudentAddRequest;
import az.developia.springjava13.response.StudentResponse;
import az.developia.springjava13.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/students")
@Api(description = "Telebelerle bagli API-lar")
@CrossOrigin(origins = "*")
public class StudentRestController {

	@Autowired
	private StudentService service;

	@GetMapping
//	@PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	@ApiOperation(value = "Butun telebeleri qaytaran API ", notes = "Burada elave qeydler yazilir")
	public StudentResponse getStudents() {
		StudentResponse response = new StudentResponse();

		List<StudentEntity> list = repository.findAll();

//		List<StudentEntity> list = repository.findAllSearch("a", "b");
//		asagidaki ile eyni isi gorur
//		
//		List<StudentEntity> filtered = list.stream().filter(s -> {
//			boolean re = false;
//			if (s.getName().contains("a") && s.getSurname().contains("b")) {
//				re = true;
//			}
//			return re;
//		}).collect(Collectors.toList());
//
		response.setStudents(list);

		return response;
	}

	@GetMapping(path = "/{id}")
	@PreAuthorize(value = "hasAuthority('ROLE_GET_STUDENT')")
	public StudentEntity findById(@PathVariable Integer id) {

		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}

		return repository.findById(id).orElseThrow(() -> new OurRuntimeException(null, "bu id tapilmadi"));

	}

//	@RequestBody arxada avtomatik olaraq studenti component annotasiyasina baglayir
	@PostMapping(path = "/add")
	@PreAuthorize(value = "hasAuthority('ROLE_ADD_STUDENT')")
	public ResponseEntity<Object> add(@Valid @RequestBody StudentAddRequest dto, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "melumatlarin tamligi pozulub");
		}
		ResponseEntity<Object> resp = service.add(dto);

		return resp;
	}

	@PutMapping
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

	@PutMapping(path = "/update-me")
	@PreAuthorize(value = "hasAuthority('ROLE_UPDATE_ME')")
//	{username:'yeniUsername'}
	public void updateMe(@RequestBody StudentUpdateMeDTO req) {
		String newUsername = req.getUsername();

		if (newUsername == null) {
			// throw
		}

//		bu kod emeliyyati edenin username i verir
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		if (newUsername.equals(username)) {
			// throw
		}
		Optional<UserEntity> f = userRepository.findById(username);
		if (f.isPresent()) {
			// throw
		} else {
			userRepository.updateMyUsername(username, newUsername);
		}

	}

}