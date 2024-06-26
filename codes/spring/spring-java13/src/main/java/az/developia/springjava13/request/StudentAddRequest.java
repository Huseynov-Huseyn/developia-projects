package az.developia.springjava13.request;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
//@ApiModel(description = "Telebe DTO")
public class StudentAddRequest {

	@Size(min = 2, max = 40, message = "Ad min 2 max 40 ola biler")
//	@ApiModelProperty(notes = "Bura telebenin adidir")
	private String name;

	@Size(min = 2, max = 40, message = "Soyad min 2 max 40 ola biler")
	private String surname;

	@Size(min = 2, max = 20, message = "Username min 2 max 20 ola biler")
//	@Pattern(regexp = "[a-z_A-Z0-9]{1,50}",message = "ad 1-50 arasinda ola biler")
	private String username;

	@Size(min = 2, max = 20, message = "Password min 6 max 20 ola biler")
	private String password;

	@Past(message = "kecmis zaman olmalidir")
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
//	Setter ve Getter ler normalda islemir deye bunlari yazdiq
	private LocalDate birthday;

//	@Pattern(regexp = "[\w-\.]+@([\w-]+\.)+[\w-]{2,4}", message = "emaili duz yaz")
	private String email;

	private Integer teacherId;
}
