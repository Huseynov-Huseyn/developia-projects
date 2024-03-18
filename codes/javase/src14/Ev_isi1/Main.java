package Ev_isi1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Extra p = new Extra();

		try {
			int a = scan.nextInt();
			int b = scan.nextInt();
			p.negative(a, b);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getmessage());
		} finally {
			System.out.println("finally code");
		}
	}
}
