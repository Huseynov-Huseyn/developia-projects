package PDF3;

public class main {
	public static void main(String[] args) {
		Employee p1 = new Employee();
		Employee p2 = new Employee();
		p1.id =1;
		p1.name ="huseyn";
		p1.surname ="huseynov";
		p1.phone = "192";
		p1.address = "cavadxan12";
		p1.salary = 100;
		
		
		System.out.println(p1.id +" "+p1.name+" " +p1.surname +" "+ p1.phone +" "+ p1.address +" "+ p1.salary  );
		
		p2.id =2;
		p2.name ="eli";
		p2.surname ="eliyev";
		p2.phone = "291";
		p2.address = "turgeyneq kucesi";
		p2.salary = 200;
		
		System.out.println(p2.id +" "+p2.name+" " +p2.surname +" "+ p2.phone +" "+ p2.address +" "+ p2.salary  );
		
	}
}
