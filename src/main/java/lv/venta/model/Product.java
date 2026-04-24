package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "ProductTable")
public class Product {
	//1.variables
	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Z]{1}[a-z ]{2,40}")
	@Column(name = "Title")
	private String title;
	
	@NotNull
	@Column(name = "Category")
	private Category category;
	
	@Min(0)
	@Max(100)
	@Column(name = "Price")
	private float price;
	
	@Min(0)
	@Max(1000)
	@Column(name = "Quantity")
	private int quantity;
	
	@NotNull
	@NotEmpty
	//TODO add @Pattern if you want
	@Column(name = "Description")
	private String description;
	
	//TODO set id unique from database
	@Column(name = "Id")
	@Id//this means that column values will be unique
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//2.getters
	//3.setters


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//4. both constructors
	public Product() {}
	
	public Product(int id, String title, Category category, 
			float price, int quantity, String description) {
		setId(id);
		setTitle(title);
		setCategory(category);
		setPrice(price);
		setDescription(description);
		setQuantity(quantity);
	}
	//5. toString 
	@Override
	public String toString()
	{
		String result = id + ": " + title + ", " + price + " eur, ["
				+ description + "] " +  quantity 
				+ "{ " + category + "}";
		return result;
	}
}
