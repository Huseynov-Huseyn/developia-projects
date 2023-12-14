package az.developia.teacher;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import az.developia.teacher.entity.TeacherGroupEntity;
import az.developia.teacher.repository.TeacherGroupRepository;

public class TeacherMainGroup {
	
	public static void main(String[] args) {
		TeacherGroupEntity teacher= new TeacherGroupEntity(null, "a8", 2, LocalDateTime.of(2020, 12, 20, 20, 10,20), 15);
	
		
	}

}
