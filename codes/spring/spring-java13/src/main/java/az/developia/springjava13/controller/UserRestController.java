package az.developia.springjava13.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.dto.AuthorDTO;
import az.developia.springjava13.dto.TeacherDTO;
import az.developia.springjava13.entity.AuthorEntity;
import az.developia.springjava13.entity.AuthorityEntity;
import az.developia.springjava13.entity.TeacherEntity;
import az.developia.springjava13.entity.UserEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.AuthorRepository;
import az.developia.springjava13.repository.AuthorityRepository;
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

	@Autowired
	private AuthorityRepository authorityRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@PostMapping(path = "/teacher")
	public boolean reateTeacher(@RequestBody TeacherDTO d) {
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

		AuthorityEntity a1 = new AuthorityEntity();
		a1.setUsername(user.getUsername());
		a1.setAuthority("ROLE_ADD_STUDENT");
		authorityRepository.save(a1);

		return true;
	}

	@PostMapping(path = "/author")
	public void createAuthor(@RequestBody AuthorDTO a) {
		Optional<UserEntity> findById = userRepository.findById(a.getUsername());
		if (findById.isPresent()) {
			throw new OurRuntimeException(null, "Username istifade edilir");
		}

		AuthorEntity b = new AuthorEntity();
		b.setId(a.getId());
		b.setName(a.getName());
		b.setSurname(a.getSurname());
		b.setUsername(a.getUsername());

		authorRepository.save(b);

		UserEntity user = new UserEntity();
		user.setUsername(a.getUsername());
		user.setPassword(a.getPassword());
		user.setEmail(a.getEmail());
		user.setEnabled(1);
		user.setType("Author");
		userRepository.save(user);

		AuthorityEntity a1 = new AuthorityEntity();
		a1.setUsername(user.getUsername());
		a1.setAuthority("ROLE_ADD_BOOK");
		authorityRepository.save(a1);
	}

	@GetMapping(path = "/login")
	public void login() {

	}
}
