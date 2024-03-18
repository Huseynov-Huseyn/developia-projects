package Tasks;

public class Person {
	int id;
	String name;
	String surname;
	int age;
	String phone;
	String address;

	public Person(int id, String name, String surname, int age, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void prinInfo() {
		System.out.println("Id:" + id);
		System.out.println("name:" + name);
		System.out.println("surname:" + surname);
		System.out.println("age:" + age);
		System.out.println("phone:" + phone);
		System.out.println("address:" + address);
	}

}
