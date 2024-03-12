package az.developia.springjava13.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springjava13.entity.BookEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.BookRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/books")
public class BookRestController {

	@Autowired
	private BookRepository repository;

	@GetMapping
	public List<BookEntity> getStudents() {
		return repository.findAll();
	}

	@GetMapping(path = "/{id}")
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
	public void add(@Valid @RequestBody BookEntity b, BindingResult br) {
		if (br.hasErrors()) {
			throw new OurRuntimeException(br, "melumatlarin tamligi pozulub");
		}
		b.setId(null);
		repository.save(b);
	}

	@PutMapping(path = "/update")
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
	public void delete(@PathVariable Integer id) {
		if (id == null || id <= 0) {
			throw new OurRuntimeException(null, "id mutleqdir");
		}

		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
		} else {
			throw new OurRuntimeException(null, "bu id tapilmadi");
		}

		repository.deleteById(id);

	}
}
