package ders10;

import java.util.Arrays;

public class evIsi1 {
	public static void main(String[] args) {
		String name="Meherrem";
		System.out.println(name);
		System.out.println("-------");		
		
		String message="Java dilini öyrənmək maraqlı və faydalıdır";
		System.out.println(message);
		System.out.println(message.length());
		System.out.println(message.charAt(7));
		System.out.println(message.indexOf("n"));
		System.out.println(message.toLowerCase());
		System.out.println(message.toUpperCase());
		System.out.println(message.isBlank());
		System.out.println("-------");

		name=" Ayxan ";
		System.out.println(name.trim());
		System.out.println("-------");

		name="«Kamil»";
		System.out.println(name.substring(0,5));
		System.out.println("-------");
	
		name="«Hüseyn Mehdizadə»";
		String[] s2=name.split(" ");
		System.out.println(Arrays.toString(s2));
	}
}
