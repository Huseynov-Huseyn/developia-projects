package az.developia.teacher;

import az.developia.teacher.exception.OurRuntimeException;
import az.developia.teacher.repository.TeacherRepository;

public class TeacherMainDeleteById {
	public static void main(String[] args) {
		
		try {
			TeacherRepository repository = new TeacherRepository();
			System.out.println(repository.findById(3));
		} catch (OurRuntimeException e) {
			System.out.println(e.getOurMessage());
		}
		
	}
}
