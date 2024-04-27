package az.developia.teacherservice;

import lombok.Data;

@Data
public class StudentResp {
	private Integer id;

	private String name;

	private Integer teacherId;
}