package az.developia.springjava13.response;

import java.util.List;

import az.developia.springjava13.entity.TeacherEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherResponse {
	private List<TeacherEntity> teachers;
	private String username;

}
