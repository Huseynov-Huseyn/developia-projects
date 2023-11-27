package ders14;

public class Main {
	public static void main(String[] args) {
		
		int[]numbers= {2,3,4};
		
		int a=0;
		try {
			a=numbers[9];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(a);
	}
}
