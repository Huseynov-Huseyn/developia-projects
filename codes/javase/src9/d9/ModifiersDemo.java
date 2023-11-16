package d9;

public class ModifiersDemo {
	public static void main(String[] args) {
		person p = new person(5, 2, 3);
		person p2 = new person(4, 5);
		person p3 = new person(100);
		person p4 = new person(2000);
		System.out.println(p4.b);
		vurma(2, 3);
		bolme(12, 3);
		toplama(10, 20);
		cixma(20, 10);
		cem(10, 20);
		cem(20, 30);
	}

	static void vurma(int a, int b) {
		int c = a * b;
		System.out.println(c);
	}

	public static void bolme(int c, int d) {
		int e = c / d;
		System.out.println(e);
	}

	protected static void toplama(int e, int f) {
		int g = e + f;
		System.out.println(g);
	}

	private static void cixma(int g, int h) {
		int x = g - h;
		System.out.println(x);
	}

	public final static void cem(int y, int u) {
		int cem = y + u;
		System.out.println(cem);
	}
}
