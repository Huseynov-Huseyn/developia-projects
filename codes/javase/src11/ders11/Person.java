package ders11;


public class Person {
	String name;
	String surname;
	int age;
	
	
	public Person(String name,String surname,int age) {
		this.name=name;
		this.surname=surname;
		this.age=age;
	}
	
	public String getName(String name) {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getSurname(String surname) {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname=surname;
	}
	
	public int getAge(int age) {
		return age;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	
//	public final void getInfo() yazsaydiq bu methodu
//	alt sinifde istifade ede bilmezdik
	public void getInfo() {
		System.out.println("Name:"+name);
		System.out.println("Surname:"+surname);
		System.out.println("age:"+age);
	}
}
