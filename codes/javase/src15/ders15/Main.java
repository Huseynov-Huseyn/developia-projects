package ders15;

public class Main {
	public static void main(String[] args) {
		
		Siyahi siyahim= new Siyahi(10,20);
		
		siyahim.yenisi(5);siyahim.yenisi(523);
		siyahim.yenisi(15);
		siyahim.yenisi(5);siyahim.yenisi(5);
		
		String hamisi=siyahim.hamisiniQaytar();		
		System.out.println(hamisi);

		siyahim.silmek(siyahim.lazimOlan(15));
		String hamisi2=siyahim.hamisiniQaytar();		
		System.out.println(hamisi2);
	}
	
}
