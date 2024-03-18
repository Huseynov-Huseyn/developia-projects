package az.developia.springjava13.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Setter
@Getter

@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(min = 2, max = 40, message = "Ad min 2 max 40 ola biler")
	@Column(length = 40)
	private String name;

	@Size(min = 1, max = 9, message = "Kitab max 1 milyard ola biler")
	private String price;

	@Column(columnDefinition = "INT")
	private Integer page_count;

	@Column(columnDefinition = "TEXT")
	private Integer authorId;

}
