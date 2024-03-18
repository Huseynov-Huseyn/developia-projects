package say_sistemleri;

public class MainIkilikSaySistemleri {
	public static void main(String[] args) {
		String ikilikString = "11011";

		int i = Integer.parseInt("1234");
		System.out.println(i);
		int i2 = Integer.parseInt(ikilikString, 2);// 1.stringi 2. say sistemini gosterir
		System.out.println(i2);
		String ikilikString2 = Integer.toBinaryString(i2);
		System.out.println(ikilikString2);

	}
}
