package lv.venta.model;

public class Product {
	//1.variables
	private String title;
	private Category category;
	private float price;
	private int quantity;
	private String description;
	private int id;
	//2.getters
	//3.setters
	//TODO set id unique
	//TODO create validations
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
