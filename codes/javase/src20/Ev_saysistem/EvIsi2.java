package Ev_saysistem;

public class EvIsi2 {
	public static void main(String[] args) {

		String s = "1001";
		int i = Integer.parseInt(s, 2);
		String s2 = Integer.toHexString(i);
		System.out.println(s2);

		String s3 = "A2";
		int i2 = Integer.parseInt(s, 16);
		String s4 = Integer.toBinaryString(i2);
		System.out.println(s4);

		int i3 = 19;
		String s5 = Integer.toHexString(i3);
		System.out.println(s5);

		String s6 = "101";
		int i4 = Integer.parseInt(s6, 2);
		String s7 = "1001";
		int i5 = Integer.parseInt(s7, 2);
		int i6 = i4 + i5;
		String s8 = Integer.toBinaryString(i6);
		System.out.println(s8);

		String s9 = "71";
		int i7 = Integer.parseInt(s9, 8);
		String s10 = "71";
		int i8 = Integer.parseInt(s10, 8);
		int i9 = i7 + i8;
		String s11 = Integer.toOctalString(i9);
		System.out.println(s11);
	}
}
