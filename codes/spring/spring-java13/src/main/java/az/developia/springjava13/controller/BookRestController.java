package az.developia.springjava13.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.entity.AuthorEntity;
import az.developia.springjava13.entity.BookEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.AuthorRepository;
import az.developia.springjava13.repository.BookRepository;
import az.developia.springjava13.repository.UserRepository;
import az.developia.springjava13.response.BookResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/books")
public class BookRestController {

	@Autowired
	private BookRepository repository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@GetMapping
	@PreAuthorize(value = "hasAuthority('ROLE_GET_BOOK')")
	public List<BookEntity> getBooks() {
		BookResponse response = new BookResponse();

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		AuthorEntity operantAuthor = authorRepository.findByUsername(username);
		Integer authorId = operantAuthor.getId();

		List<BookEntity> list = repository.findAllByAuthorId(authorId);

		response.setBooks(list);
		response.setUsername(username);

		return null;

	}

	@GetMapping(path = "/{id}")
	@PreAuthorize(value = "hasAuthority('ROLE_GET_BOOK')")
	public BookEntity findById(@PathVariable Integer id) {
		Optional<BookEntity> o = repository.findById(id);

		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}
		if (o.isPresent()) {
			return o.get();
		} else {
			throw new OurRuntimeException(null, "bu id tapilmadi");
		}

	}

	@PostMapping(path = "/add")
	@PreAuthorize(value = "hasAuthority('ROLE_ADD_BOOK')")
	public void add(@Valid @RequestBody BookEntity b, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "melumatlarin tamligi pozulub");
		}

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		AuthorEntity operantAuthor = authorRepository.findByUsername(username);
		Integer authorId = operantAuthor.getId();

		b.setId(null);
		b.setAuthorId(authorId);
		repository.save(b);
	}

	@PutMapping(path = "/update")
	@PreAuthorize(value = "hasAuthority('ROLE_UPDATE_BOOK')")
	public void update(@Valid @RequestBody BookEntity b, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "melumatlarin tamligi pozulub");
		}

		if (b.getId() == null || b.getId() <= 0) {
			throw new OurRuntimeException(null, "id null olmaz");
		}

		if (repository.findById(b.getId()).isPresent()) {
			repository.save(b);
		} else {
			throw new OurRuntimeException(null, "bu id tapilmadi");
		}

		repository.save(b);
	}

	@DeleteMapping(path = "/{id}")
	@PreAuthorize(value = "hasAuthority('ROLE_DELETE_BOOK')")
	public void delete(@PathVariable Integer id) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		AuthorEntity operator = authorRepository.findByUsername(username);
		if (operator == null) {
			throw new OurRuntimeException(null, "muellim tapilmadi");

		}

		Integer authorId = operator.getId();

		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}

		BookEntity ent = repository.findById(id).orElseThrow(() -> new OurRuntimeException(null, "Id tapilmadi"));

		if (ent.getId() == authorId) {
			repository.deleteById(id);
			userRepository.deleteById(ent.getName());

			authorRepository.deleteById(ent.getId());
		} else {
			throw new OurRuntimeException(null, "oz telebeni sil");
		}

	}
}
