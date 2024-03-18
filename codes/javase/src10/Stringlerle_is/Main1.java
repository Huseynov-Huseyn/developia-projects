package Stringlerle_is;

public class Main1 {
	public static void main(String[] args) {
		String s1 = "Hüseyn";
		String s2 = "Hüseynov";
		int i = 5;

		String s3 = "" + i;
		System.out.println(s3);

		char[] chararray = { 'a', 'b', 'c', 'd', 'e' };
		s3 = String.valueOf(chararray);
		System.out.println(s3);
		s3 = String.valueOf(chararray, 2, 3);
		System.out.println(s3);

		System.out.println(s2.concat(s1));

		String s4 = String.copyValueOf(chararray);
		System.out.println(s4);

		String s5 = "Hello world and java devs";
		char c = s5.charAt(4);
		String s6 = "hüseyn";
		System.out.println(c);
		System.out.println(s5.endsWith("devs"));
		System.out.println(s1.equals(s2));
		System.out.println(s1.equalsIgnoreCase(s6));

		String s7 = "hello";
		char[] chars = { 'd', 'd', 'd', 'd', 'd', };
		s7.getChars(2, 4, chars, 3);
		System.out.println(chars);

		String s8 = "a";
		String s9 = "c";
		System.out.println(s8.compareTo(s9));
	}
}
