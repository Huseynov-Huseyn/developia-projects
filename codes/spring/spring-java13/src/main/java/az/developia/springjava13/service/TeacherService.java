package az.developia.springjava13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.springjava13.entity.TeacherEntity;
import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository repository;

	public TeacherEntity findByUsername(String username) {
		TeacherEntity t = repository.findByUsername(username);
		if (t==null) {
			throw new OurRuntimeException(null, "muellim tapilmadi");
		}
		return t;
	}
}