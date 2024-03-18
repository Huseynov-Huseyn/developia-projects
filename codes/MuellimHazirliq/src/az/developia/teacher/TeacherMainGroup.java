package az.developia.teacher;

import az.developia.teacher.exception.OurRuntimeException;
import az.developia.teacher.repository.TeacherGroupRepository;

public class TeacherMainGroup {

	public static void main(String[] args) {
//		TeacherGroupEntity teacher=new TeacherGroupEntity(null, "HUsseyn", 9, LocalDateTime.of(2020, 12,18,11,10,17), 15);

		TeacherGroupRepository repository = new TeacherGroupRepository();
//		repository.add(teacher);
//	
//		try {
//			System.out.println(repository.findById(6));
//		} catch (OurRuntimeException e) {
//			System.out.println(e.getOurMessage());
//		}
//		
		try {
			repository.deleteById(3);
		} catch (OurRuntimeException e) {
			System.out.println(e.getOurMessage());
		}

		try {
			System.out.println(repository.findByAll(9));
		} catch (OurRuntimeException e) {
			System.out.println(e.getOurMessage());
		}
	}
}
