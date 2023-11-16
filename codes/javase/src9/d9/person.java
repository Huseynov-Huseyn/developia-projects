package d9;

public class person {
	int a;
	public int b;
	protected int c;
	private int d;
	static int z;
	
	person(int z) {
		System.out.println("default modifiers");
		System.out.println(z);
	}
	
	public person(int a,int b) {
		System.out.println("public modifiers");
	}
	
	protected person(int a,int b,int c) {
		System.out.println("protected modifiers");
	}
	
	private person(int a,int b,int c,int d) {
		System.out.println("private modifiers");
//		islemeyecek cunki daxil ola bilmirik 
	}
}
