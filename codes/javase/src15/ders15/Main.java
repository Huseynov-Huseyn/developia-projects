package ders15;

public class Main {
	public static void main(String[] args) {

		Siyahi siyahim = new Siyahi(10, 20);

		siyahim.yenisi(5);
		siyahim.yenisi(523);
		siyahim.yenisi(15);
		siyahim.yenisi(25);
		siyahim.yenisi(35);

		String hamisi = siyahim.hamisiniQaytar();
		System.out.println(hamisi);

	}

}
