package javase;

public class Car {
	String brand;
	String color;
	int maxspeed;
	int currentspeed;
	
	void start() {
		currentspeed=10;
		System.out.println("Car started");
	}
	
	void stop() {
		currentspeed=0;
		System.out.println("Car stopped");
	}
	
	
}
