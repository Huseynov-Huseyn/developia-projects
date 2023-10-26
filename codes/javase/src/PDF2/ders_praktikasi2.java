package PDF2;

import java.nio.Buffer;
import java.util.Iterator;

public class ders_praktikasi2 {

	public static void main(String[] args) {
		System.out.println("1-den 5-e kimi ededler:");
		for(int i=1; i<6; i++) {
			System.out.println(i);
		}
		System.out.println("----------");
		
		int a=12;
		int b=13;
		int c=a+b;
		System.out.println("a ve b ededinin cemi: "+c);
		System.out.println("----------");
		
		int d=a*b;
		System.out.println("a ve b ededinin hasili: "+d);
		System.out.println("----------");
		
		double r=5;
		double uzunluq=2*r*3.14;
		System.out.println("Cevrenin uzunlugu:" + uzunluq);
		System.out.println("----------");
		
		int z=2341235;
		int cem=0;
		System.out.println("ededin ozu:"+ z );
		while(z>10) {
			cem+=z%10;
			z/=10;
			if(z<10) {
				cem+=z;
			}
		}
		System.out.println("ededin reqemleri cemi: "+cem);
		
		System.out.println("----------");

		for(int v=1;v<=10;v++) {
			System.out.println(v);
		}
		
		System.out.println("----------");
		
		int k=7;
		int h=0;
		for(int j=(k-1);j>=2;--j) {
			if(k%j==0) {
				System.out.println("bu eded sade deyil");
				h++;
				break;
			}
			if(h==0) {
				System.out.println("bu eded sadedir");
				break;
			}
		}
		
		
		System.out.println("----------");
		
		for(int n=1;n<=100;n++) {
			if(n%7==0) {
				System.out.println(n);
			}
			
		}
		
		System.out.println("----------");
		
		int m=231;
		if(m%2==0) {
			System.out.println("M ədədi cütdür");
		}
		else{
			System.out.println("M ədədi cüt deyil");
		}
		
		System.out.println("----------");
		
		for(int l=1;l<=200;l++) {
			if (l%3==0 & l%7==0) {
				System.out.println(l);
			}
		}	
		
		System.out.println("----------");
		
	}
	

}
