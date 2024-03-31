package az.developia.springjava13.request;

import java.time.LocalDate;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class studentUpdateRequest {

	@Id
	@Size(min = 1, message = "id 0 ve ya menfi ola bilmez!")
	private Integer id;

	@Size(min = 2, max = 40, message = "Ad min 2 max 40 ola biler")
	private String name;

	@Size(min = 2, max = 40, message = "Soyad min 2 max 40 ola biler")
	private String surname;

	@Size(min = 2, max = 20, message = "Username min 2 max 20 ola biler")
	private String username;

	@Size(min = 2, max = 20, message = "Password min 6 max 20 ola biler")
	private String password;

	@Past(message = "kecmis zaman olmalidir")
	private LocalDate birthday;

//	@Pattern(regexp = "[\w-\.]+@([\w-]+\.)+[\w-]{2,4}", message = "emaili duz yaz")
	private String email;

	private Integer teacherId;
}
