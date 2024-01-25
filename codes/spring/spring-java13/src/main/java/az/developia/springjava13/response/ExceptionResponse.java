package az.developia.springjava13.response;

import java.util.List;

public class ExceptionResponse {
	private String message;
	private List<ValidationResponse> valdation;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ValidationResponse> getValdation() {
		return valdation;
	}
	public void setValdation(List<ValidationResponse> valdation) {
		this.valdation = valdation;
	}
	
	
}
