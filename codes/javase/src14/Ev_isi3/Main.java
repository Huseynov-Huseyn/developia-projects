package Ev_isi3;

public class Main {
	public static void main(String[] args) {
		Extra ex = new Extra();
		
		try {
			ex.sum(10, 6);
		} catch (InvalidUserInputException e) {
			System.out.println(e.getMesaj());
		}
	}
}
