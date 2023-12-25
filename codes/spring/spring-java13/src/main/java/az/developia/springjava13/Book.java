package az.developia.springjava13;

import org.springframework.stereotype.Component;

@Component
public class Book {
	private Integer id;
	private String name;
	private Integer price;
	private Integer pageCount;
	
	
	
	public Book() {
		super();
		this.id = 1;
		this.name = "Huseyn";
		this.price = 12;
		this.pageCount = 200;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	
}
