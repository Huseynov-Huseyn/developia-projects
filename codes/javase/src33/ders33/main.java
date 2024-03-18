package ders33;

public class main {

	public static void main(String[] args) {
//		Blockable user1 = () -> System.out.println("You are blocked");
//		user1.block();

		doIt((a) -> System.out.println("You are blocked" + a));
	}

	public static void doIt(Blockable b) {
		b.block(2);
	}
}