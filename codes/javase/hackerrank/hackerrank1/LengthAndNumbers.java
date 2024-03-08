package hackerrank1;

import java.util.Scanner;

public class LengthAndNumbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int uzunluq = scan.nextInt();

		int[] massiv = new int[uzunluq];

		for (int i = 0; i < massiv.length; i++) {
			massiv[i] = scan.nextInt();
		}
		scan.close();

		for (int i = 0; i < massiv.length; i++) {
			System.out.println(massiv[i]);
		}
	}
}
