package az.developia.springjava13.entity;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "my_view")
@Setter
@Getter
@Immutable
@ToString
//view bagli classlarda immutable yazilmalidir
public class DemoEntity {

	@Id
	private Integer studentId;

	private String studentName;

	private String studentUsername;

	private Integer teacherId;

	private String teacherName;

}