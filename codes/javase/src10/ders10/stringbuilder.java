package ders10;

public class stringbuilder {
	public static void main(String[] args) {
		StringBuilder s = new StringBuilder("Java");
		for (int i = 1; i < 10; i++) {
			s.append("java");
		}
		System.out.println(s);

		StringBuilder s1 = new StringBuilder();
		s1.append("bura");
		s1.insert(1, "123");
		System.out.println(s1);
		s1.delete(2, 4);
		System.out.println(s1);
		s1.reverse();
		System.out.println(s1);
		System.out.println(s1.capacity());
//		StringBuilder()bu tipde yaradilanda min 16liq yer ayirir
		s1.ensureCapacity(20);
		System.out.println(s1.capacity());

	}
}
