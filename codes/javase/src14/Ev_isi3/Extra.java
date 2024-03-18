package Ev_isi3;

public class Extra {
	public static void sum(int a, int b) throws InvalidUserInputException {
		if (a * b > 50) {
			throw new InvalidUserInputException("Yüksək rəqəm");
		} else {
			System.out.println("sizin reqemlerin hasili 50den boyuk deyil");
		}
	}
}
