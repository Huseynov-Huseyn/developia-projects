package Stringlerle_is;

public class Main_Enum {
	public static void main(String[] args) {
		Enum_constructor p1=new Enum_constructor("kofta", Size.Small);
		Enum_constructor p2=new Enum_constructor("şalvar", Size.Medium);
		Enum_constructor p3=new Enum_constructor("kurtqa", Size.Large);
		System.out.println(p3.size.getinfo());
		System.out.println(p2.size.getinfo());
		System.out.println(p1.size.getinfo());
	}
}
