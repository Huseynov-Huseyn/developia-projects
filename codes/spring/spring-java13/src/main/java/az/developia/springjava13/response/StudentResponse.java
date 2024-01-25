package az.developia.springjava13.response;

import java.util.List;

import az.developia.springjava13.component.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {
	private List<Student> students;
	private String username;

}
