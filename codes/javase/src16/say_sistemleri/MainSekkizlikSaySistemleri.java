package say_sistemleri;

public class MainSekkizlikSaySistemleri {
	public static void main(String[] args) {
		
		String sekkizlikString="6233";
		int i=Integer.parseInt(sekkizlikString,8);
		System.out.println(i);
		
		String s=Integer.toOctalString(i);
		System.out.println(s);
	}
}
