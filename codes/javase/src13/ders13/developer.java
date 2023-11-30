package ders13;

public class developer extends person{
	double salary;
	
	void printInfo() {
		super.prinInfo();
		System.out.println("salary: "+salary);
	}
}
