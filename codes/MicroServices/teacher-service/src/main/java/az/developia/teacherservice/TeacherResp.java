package az.developia.teacherservice;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherResp {

	private Integer id;

	private String name;

	private List<StudentResp> students;

}