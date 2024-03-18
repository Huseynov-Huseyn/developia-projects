package az.developia.teacher;

import java.time.LocalDateTime;

import az.developia.teacher.entity.TeacherEntity;
import az.developia.teacher.exception.OurRuntimeException;
import az.developia.teacher.repository.TeacherRepository;

public class TeacherMain {

	public static void main(String[] args) {

		// muellim frontdan oz melumatlarini daxil edir ve
		// gonderir,bu zaman melumat servere,controllere daxil
		// olur ve bu melumat bazaya yazilmali olduguna gore
		// servise gonderilir ve servis ise repoya gonderir repo da
		// cedvele yazir
		TeacherEntity teacher = new TeacherEntity(null, "Huseyn", "Huseynov", "050-456-23-42", "Baku", "Huseyn12233",
				"nemmm", LocalDateTime.now());

		TeacherRepository repository = new TeacherRepository();
		try {

			if (repository.checkUsernameIfExists(teacher.getUsername())) {
				System.out.println("Bu username artiq movcuddur");
			} else {
				repository.add(teacher);
			}

		} catch (OurRuntimeException e) {
			System.out.println(e.getOurMessage());
		}

		// burada bu entity de olan melumatlari teachers cedveline gondermek
		// lazimdir ve bunun ucun JDBC kitabxanasini istifade edeceyik

	}
}
