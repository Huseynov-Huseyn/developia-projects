package Ev_saysistem;

import java.util.Scanner;

public class EvIsi3 {
	public static void main(String[] args) {
		//Write a program that can convert numbers between any two bases (from 2 to 16).​
		System.out.println("say sisteminizi daxil edin:");
		Scanner scan = new Scanner(System.in);

		int saysistemi = scan.nextInt();
		if (saysistemi == 2 || saysistemi == 8 || saysistemi == 10 || saysistemi == 16) {
			System.out.println("indi reqeminizi daxil edin:");
		} else {
			System.out.println("sadece 2, 8, 10 ve ya 16 say sistemi qebul edilir");
		}
		
		if (saysistemi != 10) {
			String reqem = scan.next();
			System.out.println(toDecimal(reqem, saysistemi));
		} else {
			int reqem = scan.nextInt();
			System.out.println("cevrilecek say sistemini qeyd edin");
			int cevrileceksistem= scan.nextInt();
			System.out.println(fromDecimal(reqem, cevrileceksistem));
		}
		scan.close();

	}

	 public static int toDecimal(String reqem, int sayiSistemi) {
	        try {
	            return Integer.parseInt(reqem, sayiSistemi);
	        } catch (NumberFormatException e) {
	            System.out.println("Daxil olunan rəqəm bu say sistemində yoxdur");
	            return -1; // Hata durumunu işaretlemek için -1 veya başka bir değer dönebilirsiniz
	        }
	    }


	public static String fromDecimal(Integer reqem, int sistem) {
		if (sistem == 2) {
			return Integer.toBinaryString(reqem);
		}
		if (sistem == 8) {
			return Integer.toOctalString(reqem);
		}
		if (sistem == 10) {
			return "10luq say sisteminden cevrilmeler yoxdur";
		}
		if (sistem == 16) {
			return Integer.toHexString(reqem);
		} else {
			return "sehv sistem";
		}
	}
}
