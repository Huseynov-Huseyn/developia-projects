package Task2;

public class Dog extends Animal{
	
	public Dog(String name,int age) {
		super();
		this.name=name;
		this.age=age;
	}
	
	@Override
	public void makeNoise() {
		System.out.println(name+" səs edir");
	}
	
}
