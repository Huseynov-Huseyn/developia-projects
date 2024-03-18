package Ev_isi3;

public class InvalidUserInputException extends RuntimeException {
	public String mesaj;

	public InvalidUserInputException(String m) {
		mesaj = m;
	}

	public String getMesaj() {
		return mesaj;
	}
}
