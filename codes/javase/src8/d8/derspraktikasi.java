package d8;

import java.util.Random;

public class derspraktikasi {
	public static void main(String[] args) {
		int[] arr = new int[3];

		Random rastgele = new Random();
		int toplam = 0;
		for (int i = 0; arr.length > i; i++) {
			arr[i] = rastgele.nextInt(10);
			System.out.println(arr[i]);
			toplam += arr[i];
		}
		System.out.println("sizin massivinizin toplam deyeri: " + toplam);
		System.out.println("sizin massivinizin edediortasi: " + (double) toplam / arr.length);
		System.out.println("-----");

		System.out.println("Massivini icinde olan tek ededler: ");
		for (int i = 0; arr.length > i; i++) {
			if (arr[i] % 2 == 1) {
				System.out.println(arr[i]);
			}
		}
	}
}