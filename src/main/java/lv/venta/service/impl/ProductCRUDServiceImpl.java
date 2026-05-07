package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Category;
import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductCRUDService;

@Service
public class ProductCRUDServiceImpl implements IProductCRUDService{

	@Autowired
	private IProductRepo prodRepo;
	
	@Override
	public void createProduct(String title, Category category, float price, int quantity, String description)
			throws Exception {
		if(title == null 
			|| title.isEmpty() 
			|| !title.matches("[A-Z]{1}[a-z ]{2,40}")
			|| category == null
			|| price < 0
			|| price > 100
			|| quantity < 0
			|| quantity > 1000
			|| description == null
			|| description.isEmpty()) {
			throw new Exception("Input data is incorrect");
		}
		
		if(prodRepo
			.existsByTitleAndCategoryAndPriceAndQuantityAndDescription
			(title, category, price, quantity, description )) {
			throw new Exception("This product already exists in the DB");
		}
		
		Product prod = new Product(title, category, price, quantity, description);
		prodRepo.save(prod);
		
		
	}

	@Override
	public ArrayList<Product> retrieveAllProducts() throws Exception {
		if(prodRepo.count() == 0) {
			throw new Exception("There is no product in DB");
		}
		
		else
		{
			return (ArrayList<Product>)prodRepo.findAll();
		}
			
			
	}

	@Override
	public Product retrieveProductById(int id) throws Exception {
		if(id <= 0) {
			throw new Exception("Id should be positive");
		}
		
		if(!prodRepo.existsById(id)) {
			throw new Exception("Product with id " + id + " doesn't exist");
		}
		
		
		return prodRepo.findById(id).get();
	}

	@Override
	public void updateProductById(int id, String title, Category category, float price, int quantity,
			String description) throws Exception {
		if(title == null 
				|| title.isEmpty() 
				|| !title.matches("[A-Z]{1}[a-z ]{2,40}")
				|| category == null
				|| price < 0
				|| price > 100
				|| quantity < 0
				|| quantity > 1000
				|| description == null
				|| description.isEmpty()) {
				throw new Exception("Input data is incorrect");
			}
		
		Product productFromDB = retrieveProductById(id);
		productFromDB.setTitle(title);
		productFromDB.setCategory(category);
		productFromDB.setPrice(price);
		productFromDB.setQuantity(quantity);
		productFromDB.setDescription(description);
		
		prodRepo.save(productFromDB);
		
	}

	@Override
	public void deleteProductById(int id) throws Exception {
		Product productFromDB = retrieveProductById(id);
		prodRepo.delete(productFromDB);
		
	}

}
