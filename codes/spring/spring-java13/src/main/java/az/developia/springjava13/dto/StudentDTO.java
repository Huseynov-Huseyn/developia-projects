package az.developia.springjava13.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class StudentDTO {

	@NotNull(message = "id mutleqdir")
	@Min(value = 0, message = "Id menfi olmaz")
	private Integer id;

	@Size(min = 2, max = 40, message = "Ad min 2 max 40 ola biler")
	private String name;

	@Size(min = 2, max = 40, message = "Soyad min 2 max 40 ola biler")
	private String surname;

	@Size(min = 2, max = 20, message = "Username min 2 max 20 ola biler")
	private String username;

	@Size(min = 6, max = 20, message = "Password min 6 max 20 ola biler")
	private String password;

}
