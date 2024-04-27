package az.developia.teacherservice;

import java.util.List;

import lombok.Data;

@Data
public class StudentListResponse {
	private List<StudentResp> students;

}