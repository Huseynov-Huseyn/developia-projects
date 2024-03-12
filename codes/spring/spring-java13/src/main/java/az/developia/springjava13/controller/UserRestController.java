package az.developia.springjava13.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.dto.TeacherDTO;
import az.developia.springjava13.entity.TeacherEntity;
import az.developia.springjava13.entity.UserEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.TeacherRepository;
import az.developia.springjava13.repository.UserRepository;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "*")
public class UserRestController {

	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private UserRepository userRepository;

	@PostMapping(path = "/teacher")
	public void createTeacher(@RequestBody TeacherDTO d) {
		Optional<UserEntity> findById = userRepository.findById(d.getUsername());

		if (findById.isPresent()) {
			throw new OurRuntimeException(null, "Username istifade edilir");
		}

		TeacherEntity e = new TeacherEntity();
		e.setId(d.getId());
		e.setName(d.getName());
		e.setSurname(d.getSurname());
		e.setUsername(d.getUsername());
		teacherRepository.save(e);

		UserEntity user = new UserEntity();
		user.setUsername(d.getUsername());
		user.setPassword(d.getPassword());
		user.setEmail(d.getEmail());
		user.setEnabled(1);
		user.setType("teacher");
		userRepository.save(user);
	}
}
