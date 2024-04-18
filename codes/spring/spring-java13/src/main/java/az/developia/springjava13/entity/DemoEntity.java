package az.developia.springjava13.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "my_view")
@Setter
@Getter
@ToString
@Immutable
//view bagli classlarda immutable yazilmalidir ki deyisilmeler edilmesin 
public class DemoEntity {

	@Id
	private Integer studentId;

	private String studentName;

	private String studentUsername;

	private Integer teacherId;

	private String teacherName;

}
