package List;

import java.util.ArrayList;
import java.util.Iterator;

public class Array_list {
	public static void main(String[] args) {
//		arraylerin daha gelismis halidir ve serhed yoxdur

		ArrayList country = new ArrayList();

		country.add("Gandja");
		country.add("baku");
		country.add("semkir");
		country.add("susa");
		country.add("Gandja");

		country.add(0, "Gence");
//		add metodu ile verilen noqteye deyisen elave edilir 
//		ve o yerde duran deyisen bir sonraki siraya kecir
		country.remove(2);/* Baku getdi */

		Iterator itr = country.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

//		country.forEach(I -> System.out.println(I+""));
	}
}
