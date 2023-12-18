package az.developia.teacher;

import java.time.LocalDate;

import az.developia.teacher.entity.StudentEntity;
import az.developia.teacher.exception.OurRuntimeException;
import az.developia.teacher.repository.StudentRepository;

public class StudentMain {
	public static void main(String[] args) {
		StudentEntity student= new StudentEntity(null, "Huseyn", "Huseynov", "050-456-23-42", LocalDate.now());
		StudentRepository repo= new StudentRepository();
		StudentEntity student1=new StudentEntity();
		
		
		repo.add(student);
		
//		try {
//			repo.deleteById(2);
//		} catch (OurRuntimeException e) {
//			System.out.println(e.getOurMessage());
//		}
		
		try {
			System.out.println(repo.findById(1));
		} catch (OurRuntimeException e) {
			System.out.println(e.getOurMessage());
		}
		
		try {
			System.out.println(repo.findAll());
		} catch (OurRuntimeException e) {
			System.out.println(e.getOurMessage());
		}
	}
}
