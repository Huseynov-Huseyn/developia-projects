package az.developia.springjava13.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import az.developia.springjava13.exception.OurRuntimeException;
import az.developia.springjava13.response.ExceptionResponse;
import az.developia.springjava13.response.ValidationResponse;

@RestControllerAdvice
public class ExceptionHandler2 {

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ExceptionResponse handle(OurRuntimeException e) {
//		e.getBr().getFieldErrors().get(0).getField(); datatype adını
		ExceptionResponse r = new ExceptionResponse();

		BindingResult br = e.getBr();
		if (br == null) {

		} else {
			List<FieldError> fieldErrors = br.getFieldErrors();
			List<ValidationResponse> validations = new ArrayList<>();

			for (FieldError error : fieldErrors) {
				ValidationResponse v = new ValidationResponse();
				v.setField(error.getField());
				v.setMessage(error.getDefaultMessage());
				validations.add(v);
			}
			r.setValdation(validations);
		}
		r.setMessage(e.getMessage());

		return r;

//		e.getBr().getFieldErrors().get(0).getField() + ": "
//		+ e.getBr().getFieldErrors().get(0).getDefaultMessage();

	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ExceptionResponse handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
		ExceptionResponse r = new ExceptionResponse();

		r.setMessage(e.getMessage());

		return r;
	}

//	@ExceptionHandler
//	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
//	public ExceptionResponse handleAccessDeniedException(AccessDeniedException e) {
//		ExceptionResponse r = new ExceptionResponse();
//
//		r.setMessage("Huququnuz yoxdur!");
//
//		return r;
//	}

}
