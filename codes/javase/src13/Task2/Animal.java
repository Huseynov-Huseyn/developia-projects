package Task2;

public abstract class Animal {
	int age;
	String name;

	public abstract void makeNoise();

	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
