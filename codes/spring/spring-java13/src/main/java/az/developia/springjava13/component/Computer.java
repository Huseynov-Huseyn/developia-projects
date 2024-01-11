package az.developia.springjava13.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component(value = "myComputer1	")
public class Computer {
	private Integer id;
	private String brand;
	private Integer price;
	private String color;
	@Autowired
	private Ram ram;

	public Computer() {
		this.id = 1;
		this.brand = "Acer";
		this.price = 2900;
		this.color = "black";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", brand=" + brand + ", price=" + price + ", color=" + color + ", ram=" + ram
				+ "]";
	}

	@PostConstruct
	public void init() {
		System.out.println("init method");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("destroy method");
	}
}
