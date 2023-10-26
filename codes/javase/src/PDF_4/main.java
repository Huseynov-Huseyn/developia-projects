package PDF_4;

public class main {
	public static void main(String[] args) {
		
	printName(1, "Huseyn");
	printName(2, "Eli");
	printName(3, "Veli");
	
	System.out.println("-------");
	
	edediOrta(2,4);
	edediOrta(4,10);
	edediOrta(4,12);
	}
	
	public static void printName(int counter, String name) {
		
		System.out.println(counter + name);
	}
	
	
	
	public static void edediOrta(int eded1, int eded2) {
		int average=eded1+eded2;
		System.out.println((average/2));
	
	}
	
}
