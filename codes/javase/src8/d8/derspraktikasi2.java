package d8;

import java.nio.Buffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class derspraktikasi2 {
	public static void main(String[] args) {
		Random rasgele = new Random();
		int[] array1 = new int[4];
		int toplam = 0;
		for (int i = 0; i < array1.length; i++) {
			array1[i] = rasgele.nextInt(100);
			toplam += array1[i];
		}

		for (int i : array1) {
			System.out.println("deyer: " + i);
		}

		System.out.println("massivin ededi ortası: " + (double) toplam / array1.length);
		System.out.println("-------");

		int max = 0;
		int min = 9;
		System.out.println("massivdeki tek ededler:");
		for (int i = 0; array1.length > i; i++) {
			if (array1[i] > max) {
				max = array1[i];
			}
			if (array1[i] < min) {
				min = array1[i];
			}

			if (array1[i] % 2 == 1) {
				System.out.println(array1[i]);
			}
		}
		System.out.println("-------");
		System.out.println("massivdeki cüt ededler:");
		for (int i = 0; array1.length > i; i++) {
			if (array1[i] % 2 == 0) {
				System.out.println(array1[i]);
			}
		}

		System.out.println("-------");
		System.out.println("array1in max deyeri:" + max);

		System.out.println("array1in min deyeri:" + min);
		System.out.println("-------");

		int x = 0;
		for (int z = 0; array1.length > z; z++) {
			for (int i = 2; array1[z] > i; i++) {
				if (array1[z] % i == 0) {
					x++;
				}
			}
			if (x == 0) {
				System.out.println(array1[z]);
			} else {
				System.out.println((z + 1) + ". eded sade deyil");
			}
		}

		System.out.println("------");

		int[] array2 = { 20, 30, 10 };
		Arrays.sort(array2);
		System.out.println(array2[0]);
		System.out.println(array2[1]);
		System.out.println(array2[2]);

		System.out.println("------");

		int[] denemearray = { 1, 3, 5, 7, 9, 11, 13 };
		int axtarilandeyer = 7;
		int indeks = Arrays.binarySearch(denemearray, axtarilandeyer);
		System.out.println(indeks);

	}

}