package Task2;

public class Cat extends Animal{
	
	public Cat(String name,int age) {
		super();
		this.name=name;
		this.age=age;
	}
	
	@Override
	public void makeNoise() {
		System.out.println(name+" səs edir");
	}
	
}
