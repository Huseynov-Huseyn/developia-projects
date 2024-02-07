package hackerrank1;

import java.util.Scanner;

public class JavaCurrencyFormatter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double payment = scanner.nextDouble();
		scanner.close();
		
		String us = "$" + payment;
		String india = "Rs." + payment;
		String china = "￥" + payment;
		String france = payment + "€";

		System.out.println("US: " + us);
		System.out.println("India: " + india);
		System.out.println("China: " + china);
		System.out.println("France: " + france);
	}
}
