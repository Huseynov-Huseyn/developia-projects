package Ev_saysistem;

import java.util.Scanner;

public class EvIsi4 {
	public static void main(String[] args) {
//		Design a calculator that can perform arithmetic operations 
//		(+, -, *, /) on numbers of different bases (binary, octal, 
//		decimal, hexadecimal) and display the result in a chosen base. ​
		int toplananreqem1;
		int toplananreqem2;

		
		System.out.println("say sisteminizi daxil edin:");
		Scanner scan = new Scanner(System.in);

		int saysistemi = scan.nextInt();
		saySistemiDogrulugu(saysistemi);
		if (saysistemi != 10) {
			String girilenreqem = scan.next();
			toplananreqem1 = toDecimal(girilenreqem, saysistemi);
			if (toplananreqem1==-1) {
				scan.close();
				System.exit(0);
			}
		} else {
			toplananreqem1 = scan.nextInt();
		}
		
		System.out.println("ediləcək əməli seçin(+,-,*,/)");
		String giris=scan.next();
		char emel=giris.charAt(0);
		if (emel == '+' || emel == '-' || emel == '*'  || emel == '/' ) {
			System.out.println("say sisteminizi daxil edin:");
		}else {
			System.out.println("Sadəcə 4 əməl qeyd oluna bilər");
		}
		
		int saysistemi2 = scan.nextInt();
		saySistemiDogrulugu(saysistemi2);
		
		if (saysistemi2 != 10) {
			String girilenreqem2 = scan.next();
			toplananreqem2 = toDecimal(girilenreqem2, saysistemi2);
			if (toplananreqem2==-1) {
				scan.close();
				System.exit(0);
			}
		} else {
			toplananreqem2 = scan.nextInt();
		}
		
		System.out.println("cixis say sisteminizi daxil edin:");
		int saysistemi3 = scan.nextInt();
		if (saysistemi3 == 2 || saysistemi3 == 8 || saysistemi3 == 10 || saysistemi3 == 16) {}
		else {
			System.out.println("sadece 2, 8, 10 ve ya 16 say sistemi qebul edilir");
		}
		
		
		if (emel=='+') {
			if (saysistemi3==10) {
				System.out.println(	toplama(toplananreqem1, toplananreqem2));
			}else {
				System.out.println(fromDecimal(toplama(toplananreqem1, toplananreqem2), saysistemi3));
			}	
		}else {
			
		}
		
		if (emel=='-') {
			if (saysistemi3==10) {
				System.out.println(	cixma(toplananreqem1, toplananreqem2));
			}else {
				System.out.println(fromDecimal(cixma(toplananreqem1, toplananreqem2), saysistemi3));
			}	
		}else {
			
		}
		
		if (emel=='*') {
			if (saysistemi3==10) {
				System.out.println(	vurma(toplananreqem1, toplananreqem2));
			}else {
				System.out.println(fromDecimal(vurma(toplananreqem1, toplananreqem2), saysistemi3));
			}
		}else {
			
		}
		
		if (emel=='/') {
			if (saysistemi3==10) {
				System.out.println(	bolme(toplananreqem1, toplananreqem2));
			}else {
				System.out.println(fromDecimal(bolme(toplananreqem1, toplananreqem2), saysistemi3));
			}	
		}else {
			
		}
		
		scan.close();
		
	}

	public static void saySistemiDogrulugu(int say) {
		if (say == 2 || say == 8 || say == 10 || say == 16) {
			System.out.println("indi reqeminizi daxil edin:");
		} else {
			System.out.println("sadece 2, 8, 10 ve ya 16 say sistemi qebul edilir");
		}
	}

	public static int toDecimal(String reqem, int sayiSistemi) {
		try {
			return Integer.parseInt(reqem, sayiSistemi);
		} catch (NumberFormatException e) {
			System.out.println("Daxil olunan dəyişən bu say sistemində yoxdur");
			return -1;
		}
	}

	public static int toplama(int i1, int i2) {
		return i1 + i2;
	}

	public static int cixma(int i3, int i4) {
		return i3 - i4;
	}

	public static int vurma(int i5, int i6) {
		return i5 * i6;
	}

	public static int bolme(int i7, int i8) {
		return i7 / i8;
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