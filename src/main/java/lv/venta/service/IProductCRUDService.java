package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Category;
import lv.venta.model.Product;

public interface IProductCRUDService {
	//only abstract functions
	//C- create
	public abstract void createProduct(String title, 
			Category category, float price, 
			int quantity, String description) throws Exception;
	
	//R - retrieve all
	public abstract ArrayList<Product> 
			retrieveAllProducts() throws Exception;
	
	//R - retrieve by id
	public abstract Product retrieveProductById(int id)
							throws Exception;
	
	//U - update by id
	public abstract void updateProductById(int id, String title, 
			Category category, float price, 
			int quantity, String description) throws Exception;
	
	//D - delete by id
	public abstract void deleteProductById(int id) 
			throws Exception;
	
}
