package javase;

import java.util.Iterator;

public class for_if {

	public static void main(String[] args) {
//		for(int i=10;i<=16;i++) {
//			System.out.println(i);
//		}
		
		System.out.println("-----------");
		
//		for(int i=2;i<11;i+=2) {
//			System.out.println(i);
//		}
		int toplam=0;
		for(int i=1;i<20;i++) {
			if(i%2==0) /*(i%2==1) olarsa ise tekleri gosterecek*/ {
				toplam+=i;
			}
		}
		System.out.println("1-den 20-e kimi ededlerin cem="+ toplam);
		
		System.out.println("-----------");
		
		for(int i=1; i<55;i++) {
			if(i%2==0) {
				System.out.println("Huseyn");
			}
			else {
				System.out.println(i);
			}
		}
		
		
	}
	
}
