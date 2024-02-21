package az.developia.springjava13.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class StudentDTO {
	
	@NotNull(message = "id mutleqdir")
	@Min(value=0,message = "Id menfi olmaz")
	private Integer id;

	@Size(min = 2, max = 40, message = "Ad min 2 max 40 ola biler")
	private String name;

	@Size(min = 2, max = 40, message = "Soyad min 2 max 40 ola biler")
	private String surname;

	@Size(min = 2, max = 20, message = "Username min 2 max 20 ola biler")
	private String username;

	@Size(min = 6, max = 20, message = "Password min 6 max 20 ola biler")
	private String password;

	@Past(message = "kecmis zaman olmalidir")
	private LocalDate birthday;
	
	@Pattern(regexp = "[a-z]+@[a-z]+\\.[a-z]{2,4}",message = "emaili duz yaz")
	private String email;
}