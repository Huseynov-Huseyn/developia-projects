package az.developia.springjava13.component;

import org.springframework.stereotype.Component;

@Component(value = "myRam1")
public class Ram {
	private String speed;
	private Integer price;

	public Ram() {
//		this.speed="2000mb/sec";
//		this.price=230;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Ram [speed=" + speed + ", price=" + price + "]";
	}

}
