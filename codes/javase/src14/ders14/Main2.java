package ders14;

public class Main2 {
	public static void main(String[] args) {
		Extra p = new Extra();
		int[] array = { 10, 30, 50, 20 };

		try {
			System.out.println(p.giveArrayElement(array, 2));

//			int a=5;
//			int b=0;
//			int c=a/b;
//			System.out.println(c);
		} catch (Exceptionclass e) {
			System.out.println(e.getBizimMesaj());
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("qaranti kod");
		}

	}
}
