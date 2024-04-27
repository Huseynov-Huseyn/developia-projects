package az.developia.studentservice.response;

import java.util.List;

import az.developia.studentservice.entity.StudentEntity;
import lombok.Data;

@Data
public class StudentListResponse {
	private List<StudentEntity> students;
}