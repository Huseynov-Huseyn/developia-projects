package Task2;

public class Lion extends Animal{
	
	public Lion(String name,int age) {
		super();
		this.name=name;
		this.age=age;
	}
	
	@Override
	public void makeNoise() {
		System.out.println(name+" səs edir");
	}
	
}
