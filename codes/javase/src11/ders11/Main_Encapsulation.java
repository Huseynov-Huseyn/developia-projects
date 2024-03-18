package ders11;

//deyisenleri bir yere toplayib kenardan istifadesini
//qadagan edirik ve yalnizca methodlarla deyisenleri
//istifade ede bilerik
public class Main_Encapsulation {
	private String name;
	private String surname;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
