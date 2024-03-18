package az.developia.teacher;

import java.time.LocalTime;

import az.developia.teacher.entity.GroupScheduleEntity;
import az.developia.teacher.repository.GroupScheduleRepository;

public class TeacherMainSchedule {

	public static void main(String[] args) {
		GroupScheduleEntity entity = new GroupScheduleEntity(null, 3, 5, LocalTime.now());

		GroupScheduleRepository repo = new GroupScheduleRepository();

		repo.add(entity);
	}
}
