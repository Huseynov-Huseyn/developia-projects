package Ev_isi1;

public class IllegalArgumentException extends RuntimeException {
	public String message;

	public IllegalArgumentException(String m) {
		message = m;
	}

	public String getmessage() {
		return message;
	}
}
