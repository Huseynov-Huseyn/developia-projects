package ders14;

public class Exceptionclass extends RuntimeException {
	private String bizimMesaj;

	public Exceptionclass(String m) {
		bizimMesaj = m;
	}

	public String getBizimMesaj() {
		return bizimMesaj;
	}
}
