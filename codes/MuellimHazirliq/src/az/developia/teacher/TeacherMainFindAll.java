package az.developia.teacher;

import az.developia.teacher.exception.OurRuntimeException;
import az.developia.teacher.repository.TeacherRepository;

public class TeacherMainFindAll {
	public static void main(String[] args) {

		try {
			TeacherRepository repository = new TeacherRepository();
			System.out.println(repository.findAll());
		} catch (OurRuntimeException e) {
			System.out.println(e.getOurMessage());
		}

	}
}
