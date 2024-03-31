package az.developia.springjava13.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BookDTO {

	@Size(min = 2, max = 40, message = "Ad min 2 max 40 ola biler")
	private String name;

	@Size(min = 1, max = 9, message = "Kitab max 1 milyard ola biler")
	private String price;

	private Integer page_count;

	@Past(message = "kecmis zaman olmalidir")
	private LocalDate realaseDate;

	private String authorId;
}
