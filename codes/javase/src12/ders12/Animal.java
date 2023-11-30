package ders12;

public class Animal {
	private String ad;
	private int birthday;
	private double weight;
	private String color;
	private String gender;

	public Animal(String ad, int birthday, double weight) {
		this.ad = ad;
		this.birthday = birthday;
		this.weight = weight;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
