package ders13;

import java.awt.Image;

class Main {

	public static void main(String[] args) {
//		Tostring metodu
		
		ToString bir= new ToString("Huseyn", "Huseynov");
		System.out.println(bir);
		System.out.println("------------");

//		isnstanceof və upcasting downcasting
		person p= new developer();
		p.name="Huseyn";
		p.prinInfo();
		if (p instanceof developer) {
			developer dev = (developer)p;
			dev.salary=123.0d;
			dev.printInfo();	
		}
		System.out.println("------------");
		
//		Finalize
		System.out.println("Main begins");
		Finalize p2=new Finalize();
		p2=new Finalize();
		System.gc();
		
		System.out.println("------------");

//		anonim sinif
		eatable dog= new eatable() {
			
			@Override
			public void eat() {
				System.out.println("dog eats");
			}
		};
		dog.eat();
	}
}
