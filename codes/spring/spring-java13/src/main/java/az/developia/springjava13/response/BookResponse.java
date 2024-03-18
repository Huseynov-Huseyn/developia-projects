package az.developia.springjava13.response;

import java.util.List;

import az.developia.springjava13.entity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {
	private List<BookEntity> books;
	private String username;

}
