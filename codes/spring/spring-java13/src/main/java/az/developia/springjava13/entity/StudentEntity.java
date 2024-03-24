package az.developia.springjava13.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
	// primary key id-dir
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(columnDefinition = "TEXT")
	private String name;

	private String surname;

	@NotNull
//	@Bizimkiler(value = "dea") // eve calisma
	private String username;

	private Integer teacherId;

}