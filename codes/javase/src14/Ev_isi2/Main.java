// 5. suali yaza bilmedim

package Ev_isi2;

public class Main {
	public static void main(String[] args) {
		int[] numbers = { 2, 3, 4 };

		int z = 5;

		System.out.println(method_a(5, 2));
		try {
			arraylength(numbers, z);
			try {

			} catch (ArithmeticException e2) {
				System.out.println(e2.getMessage());
			}
		} catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void arraylength(int[] array, int index) {
		if (index >= array.length) {
			throw new ArrayIndexOutOfBoundsException("Olmayan elemente muraciet etdiniz");
		}
	}

	public static int method_a(int b, int a) {
		int c = a + b;
		int d = method_b(c, b) + a;
		return d;
	}

	public static int method_b(int c, int b) {
		return c * b;
	}
}
