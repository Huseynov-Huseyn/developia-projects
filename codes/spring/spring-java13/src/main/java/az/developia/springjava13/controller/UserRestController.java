package az.developia.springjava13.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.validation.BindingResult;
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
import az.developia.springjava13.entity.StudentEntity;
import az.developia.springjava13.entity.TeacherEntity;
import az.developia.springjava13.entity.UserEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.AuthorRepository;
import az.developia.springjava13.repository.AuthorityRepository;
import az.developia.springjava13.repository.BookRepository;
import az.developia.springjava13.repository.StudentRepository;
import az.developia.springjava13.repository.TeacherRepository;
import az.developia.springjava13.repository.UserRepository;
import az.developia.springjava13.request.StudentAddRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
//yuxaridaki annotasiyani yazanda autowiredda ehtiyac qalmadan repository isletmek olur ve yaxsi qaydasi budur
public class UserRestController {

//	private final TeacherRepository teacherRepository;

	private final TeacherRepository teacherRepository;
	private final UserRepository userRepository;
	private final AuthorityRepository authorityRepository;
	private final StudentRepository studentRepository;

	private final ModelMapper modelMapper;

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;

	@PostMapping(path = "/teacher")
	public boolean createTeacher(@Valid @RequestBody TeacherDTO d) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<UserEntity> findById = userRepository.findById(d.getUsername());

		if (findById.isPresent()) {
			throw new OurRuntimeException(null, "Username istifade edilir");
		}

		TeacherEntity e = new TeacherEntity();
		modelMapper.map(d, e);
		teacherRepository.save(e);

		UserEntity user = new UserEntity();
		modelMapper.map(d, user);

		String raw = d.getPassword();
//		String pass = encoder.encode(raw);
//		user.setPassword(pass);
		user.setEnabled(1);
		user.setType("teacher");
		userRepository.save(user);

		AuthorityEntity a1 = new AuthorityEntity();
		modelMapper.map(user, a1);
		a1.setAuthority("ROLE_ADD_STUDENT");
		authorityRepository.save(a1);

		return true;
	}

	@PostMapping(path = "/student")
//	@PreAuthorize(value = "hasAuthority('ROLE_ADD_STUDENT')")
	public boolean createStudent(@Valid @RequestBody StudentAddRequest d, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "melumatlarin tamligi pozulub");
		}

//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<UserEntity> findById = userRepository.findById(d.getUsername());

		if (findById.isPresent()) {
			throw new OurRuntimeException(null, "Username istifade edilir");

		}

		StudentEntity e = new StudentEntity();
		e.setName(d.getName());
//		d e
		e.setSurname(d.getSurname());
		e.setUsername(d.getUsername());

//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
//		TeacherEntity operatorTeacher = teacherRepository.findByUsername(username);
//		Integer teacherId = operatorTeacher.getId();

		e.setTeacherId(12312412);
		studentRepository.save(e);

		UserEntity user = new UserEntity();
		user.setUsername(d.getUsername());

		String raw = d.getPassword();
//		String pass = "{bcrypt}" + encoder.encode(raw);
//		user.setPassword(pass);
		user.setEmail(d.getEmail());
		user.setEnabled(1);
		user.setType("student");
		userRepository.save(user);

		AuthorityEntity a1 = new AuthorityEntity();
		a1.setUsername(user.getUsername());
		a1.setAuthority("ROLE_UPDATE_STUDENT");
		authorityRepository.save(a1);

		return true;
	}

	@PostMapping(path = "/author")
	public void createAuthor(@Valid @RequestBody AuthorDTO a) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

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

		String raw = a.getPassword();
//		String pass = "{bcrypt}" + encoder.encode(raw);

//		user.setPassword(pass);
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
