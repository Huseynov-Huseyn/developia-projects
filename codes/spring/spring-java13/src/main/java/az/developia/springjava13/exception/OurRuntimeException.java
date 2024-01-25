package az.developia.springjava13.exception;

import org.springframework.validation.BindingResult;

import az.developia.springjava13.component.Student;
import az.developia.springjava13.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class OurRuntimeException extends RuntimeException {
	// global error response

	private BindingResult br;

	public OurRuntimeException(BindingResult br, String m) {
		super(m);
		this.br = br;
		
//		builder daha dinamikdir cunki yeni constructor yaratmirsan 
//		StudentDTO f=new StudentDTO("Umid","Alesgerov");
		StudentDTO f= StudentDTO.builder().name("Umid").surname("Alesgerov").build();
	}
}
