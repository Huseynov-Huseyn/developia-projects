package ders10;

public class qeydler2 {
	public static void main(String[] args) {
		String name="Huseyn";
		String adress="Baku";
		int age=18;
		String s1=String.format("my name is %s, i am %d and im living in %s",name,age,adress);
		System.out.println(s1);
		
		System.out.println("\t salam");
//		ara vermek
		System.out.println(" \"salam\" ");
//		" isaresi qoymaq
		System.out.println(" \\salam\\ ");
//		\ isaresi qoymaq ucun
		System.out.println(" \nsalam");
//		yeni setre kecmek ucun
		
		double d=142.2323;
		String result=String.format("%.2f", d);
		System.out.println(result);
	}
}
