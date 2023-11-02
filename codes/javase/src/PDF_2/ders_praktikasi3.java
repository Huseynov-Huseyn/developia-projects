package PDF_2;

public class ders_praktikasi3 {

	public static void main(String[] args) {
		for(int i=50;i>=21;--i) {
			System.out.println(i);
		}
		
		System.out.println("-----------");
		
		double b=0.1d;
		for(double a=0;a<=5;a+=0.1) {
			System.out.println(a);
		}
		
		System.out.println("-----------");
		
		int s=13412454;
		int z=0;
		int max=0;
		while (s>=1) {
			z=(s%10);
			s/=10;
			if(z>=max) {
				max=z;
			}
		}
		System.out.println(max);
		
		System.out.println("-----------");
	
		int d=103412454;
		int f=0;
		int min=9;
		while (d>=1) {
			f=(d%10);
			d/=10;
			if(min>=f) {
				min=f;
			}
		}
		System.out.println(min);
	}
	
	
		
}
