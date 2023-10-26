package PDF_3;

public class Computer {
	 int id;
	 String brand;
	 String model;
	 String color;
	 
	 public Computer() {
		 
	 }
	 
	 public Computer(String model)/*burada model konstruktorun parametridir,gonderilen deyer ise arqumentdir*/ {
			 System.out.println("Bu maşının modeli:" +model +"dir.");
	 }
	
	 public Computer(String model,String color) {
		 System.out.println("Bu maşının modeli:" +model +"dir" +" və rəngi:"+color+"dır.");
	 }
}
