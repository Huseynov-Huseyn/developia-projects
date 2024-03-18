package Stringlerle_is;

public enum Size {
	Small("Kiçik olan ölçüdür"), Medium("Orta olan ölçüdür "), Large("Böyük olan ölçüdür");

	private String info;

	private Size(String info) {
		this.info = info;
	}

	public String getinfo() {
		return info;
	}
}
