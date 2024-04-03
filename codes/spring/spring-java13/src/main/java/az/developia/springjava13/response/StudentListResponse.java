package az.developia.springjava13.response;

import java.util.List;

import az.developia.springjava13.model.StudentResponseModel;
import lombok.Data;

@Data
public class StudentListResponse {
	private List<StudentResponseModel> students;
}