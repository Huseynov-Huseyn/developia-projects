package ders10;

import java.util.Arrays;
import java.util.Random;

public class evIsi2 {
	public static void main(String[] args) {
		char[] c1 = new char[5];
		c1[0] = 'A';
		c1[1] = 'W';
		c1[2] = 'C';
		c1[3] = 'G';
		c1[4] = 'D';
		String s1;
		s1 = Arrays.toString(c1);
		System.out.println(s1);
		System.out.println(s1.isBlank());
		System.out.println(metod("salam", "lam"));
		Random rastgele = new Random();
		int a = rastgele.nextInt(20);
		a += 10;
		System.out.println(a);

		double q = 12.2319;
		String w = String.format("%.2f", q);
		System.out.println(w);
	}

	public static boolean metod(String a1, String a2) {
		boolean cavab = a1.endsWith(a2);
		return cavab;
	}
}
