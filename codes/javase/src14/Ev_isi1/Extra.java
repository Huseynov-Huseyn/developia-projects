package Ev_isi1;

public class Extra {
	public static void negative(int a, int b) throws IllegalArgumentException {
		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("Illegal number");
		}
	}
}
