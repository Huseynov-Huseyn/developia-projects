package az.developia.springjava13.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@ApiModel(description = "Telebe DTO")
public class StudentDTO {

	@Size(min = 2, max = 40, message = "Ad min 2 max 40 ola biler")
	@ApiModelProperty(notes = "Bura telebenin adidir")
	private String name;

	@Size(min = 2, max = 40, message = "Soyad min 2 max 40 ola biler")
	private String surname;

	@Size(min = 2, max = 20, message = "Username min 2 max 20 ola biler")
	@NotNull
	private String username;

	@Size(min = 2, max = 20, message = "Password min 6 max 20 ola biler")
	@NotNull
	private String password;

	@Past(message = "kecmis zaman olmalidir")
	private LocalDate birthday;

//	@Pattern(regexp = "[\w-\.]+@([\w-]+\.)+[\w-]{2,4}", message = "emaili duz yaz")
	private String email;

	private Integer teacherId;
}
