package ders13;

public class ToString {
	private String name;
	private String surname;

	public ToString(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public String toString() {
		return "Fullname:" + name + " " + surname + "";
	}
}
