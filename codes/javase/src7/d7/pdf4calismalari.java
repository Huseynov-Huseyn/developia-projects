package d7;

import java.util.Scanner;

public class pdf4calismalari {

	public static void main(String[] args) {
		System.out.println(calculateSum(10, 20));

		Scanner scanner = new Scanner(System.in);
		System.out.println("Rəqəm daxil edin:");

		int a = scanner.nextInt();
		System.out.println("Sizin Rəqəmin faktorialı:" + calculateFactorial(a));
		scanner.close();
	}

	public static int calculateFactorial(int a) {
		int toplam = 1;
		while (a > 0) {
			toplam *= a;
			a--;
		}
		return toplam;
	}

	public static int calculateSum(int a, int b) {
		return a + b;
	}
}
