package az.developia.springjava13.handler;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.springjava13.exception.OurRuntimeException;

@RestControllerAdvice
public class ExceptionHandler2 {

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public String handle(OurRuntimeException e) {
//		e.getBr().getFieldErrors().get(0).getField(); datatype adını
		BindingResult br = e.getBr();
		if (br == null) {

		} else {
			List<FieldError> fieldErrors = br.getFieldErrors();
		}

		return e.getMessage();

//		e.getBr().getFieldErrors().get(0).getField() + ": "
//		+ e.getBr().getFieldErrors().get(0).getDefaultMessage();

	}
}
