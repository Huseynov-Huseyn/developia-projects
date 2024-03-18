package Ev_saysistem;

public class EvIsi1 {
	public static void main(String[] args) {
		String s = "1010";
		int i = Integer.parseInt(s, 2);
		System.out.println(i);

		int i2 = 10;
		String s2 = Integer.toBinaryString(i2);
		System.out.println(s2);

		String s3 = "1A";
		int i3 = Integer.parseInt(s3, 16);
		System.out.println(i3);

		int i4 = 8;
		String s4 = Integer.toOctalString(i4);
		System.out.println(s4);

		String s5 = "10";
		int i5 = Integer.parseInt(s5, 8);
		System.out.println(i5);
	}
}
