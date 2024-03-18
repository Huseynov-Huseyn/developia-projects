package ders20;

import java.util.ArrayList;

public class Comparable {
	public static void main(String[] args) {
//		ArrayList<String> name = new ArrayList<>();
//		name.add("Huseyn");
//		name.add("Eli");
//		name.add("Veli");
//		name.add("Huseyn");
//		name.add("Ayxan");
//		name.add("Eli");
//		name.add("Huseyn");
//
//		System.out.println(name);
//		Collections.sort(name);
//		System.out.println(name);
//		
		ArrayList<Person> persons = new ArrayList<>();
		persons.add(new Person(1, "Huseyn", "Huseynov", "050-456-23-42"));
		persons.add(new Person(3, "Ayxan", "Mirzezade", "055-426-53-92"));
		persons.add(new Person(2, "Rustem", "Huseynov", "070-656-73-82"));

		System.out.println(persons);

//		Collections.sort(persons);
	}
}
