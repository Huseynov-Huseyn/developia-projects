package az.developia.teacherservice;

import java.util.List;

import lombok.Data;

@Data
public class TeacherListResponse {

	private List<TeacherEntity> teachers;

	private List<TeacherResp> teachersWithStudents;

}