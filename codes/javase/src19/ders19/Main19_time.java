package ders19;

import java.time.LocalDate;
import java.util.Date;

public class Main19_time {
	public static void main(String[] args) {

		LocalDate l1 = LocalDate.now(); 
		// immutable
		System.out.println(l1);
		
		LocalDate l2 = LocalDate.of(2010, 3, 5);
	
		System.out.println(l2.isBefore(l1));
		
		System.out.println(l1.plusWeeks(1));
		
//		Date.valueOf
		
		
	}
}
