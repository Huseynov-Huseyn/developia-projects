package ders13;

public class Finalize {
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("last words of finalize method...");
	}
}
