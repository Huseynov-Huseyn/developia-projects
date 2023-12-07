package ders15_yeni;

public class Main {
	public static void main(String[] args) {
		
		Siyahi<String> siyahim= new Siyahi(15,2);
		Siyahi<Integer> siyahim2= new Siyahi(15,2);
		
		siyahim.yenisi("sa");
		siyahim.yenisi("as");
		siyahim.yenisi("nbr");
		
		siyahim2.yenisi(5);
		siyahim2.yenisi(15);
		siyahim2.yenisi(25);
		siyahim2.yenisi(35);
		
		String hamisi=siyahim.hamisiniQaytar();		
		System.out.println(hamisi);
		String hamisi2=siyahim2.hamisiniQaytar();		
		System.out.println(hamisi2);
		
		System.out.println("------------");
		siyahim2.silmek(1);
		System.out.println(siyahim2.hamisiniQaytar());
	}
	
}
