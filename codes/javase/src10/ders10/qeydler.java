package ders10;

import java.util.Arrays;

public class qeydler {
	public static void main(String[] args) {
		String s1 = "salam";
		String s2 = "aleykum";

		int a = s1.length();
		System.out.println(a);

		String s3 = s1.concat(s2);
		System.out.println(s3);

		char c = s1.charAt(2);
//		s1 stringinde 2. simvol
		System.out.println(c);

		System.out.println(s2.endsWith("um"));
		System.out.println(s2.equals(s3));

		String s4 = "Huseyn";
		char[] massiv = { 'A', 'B', 'C' };
		s4.getChars(0, 2, massiv, 1);
		System.out.println(massiv);

		String s6 = "menim adim Huseyndir";
		String s7 = "Hus";
		System.out.println(s6.indexOf(s7));
		System.out.println(s6.indexOf("ad"));

		String pattern = "[0-9]{3}-[0-9]{3}-[0-9]{2}-[0-9]{2}";
		String number1 = "050-456-23-42";
		System.out.println(number1.matches(pattern));

		String s8 = "developer";
		String s9 = "developia";
		System.out.println(s9.regionMatches(0, s8, 0, 4));
//		s9. 0. heddinden baslayaraq s8 0-5 simvollarinin eyniliyini yoxlayir

		String s10 = "abcdefghx";
		char[] array = s10.toCharArray();
		System.out.println(array);
		System.out.println(array[4]);

		System.out.println("------");
		String s11 = "A";
		System.out.println(s11.compareTo("B"));
		s11 = "B";
		System.out.println(s11.compareTo("B"));
		s11 = "C";
		System.out.println(s11.compareTo("B"));
		System.out.println("------");

		String s12 = "  ";
		System.out.println(s12.isBlank());
		System.out.println(s12.isEmpty());
		System.out.println("------");

		String s13 = "salam";
		System.out.println(s13.replace("m", "m aleykum"));

		String s14 = "Java language";
		String[] s15 = s14.split(" ");
		System.out.println(Arrays.toString(s15));
		System.out.println("------");

		System.out.println(s14.startsWith("J"));
		System.out.println(s14.endsWith("E"));
		System.out.println("------");

		String s16 = s6.substring(0, 10);
		System.out.println(s16);

		String s17 = "Salam";
		System.out.println(s17.toUpperCase());
		System.out.println(s17.toLowerCase());
		System.out.println("------");

		String s18 = " BOSLUQLAR ";
		System.out.println(s18);
		System.out.println(s18.trim());
	}
}
