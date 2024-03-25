package az.developia.springjava13.exception;

import org.springframework.validation.BindingResult;

import az.developia.springjava13.request.StudentAddRequest;
import lombok.AllArgsConstructor;
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
		StudentAddRequest f = StudentAddRequest.builder().name("Umid").surname("Alesgerov").build();
	}
}
