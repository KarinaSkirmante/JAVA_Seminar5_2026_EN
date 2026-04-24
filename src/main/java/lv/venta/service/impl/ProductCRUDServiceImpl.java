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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProductById(int id, String title, Category category, float price, int quantity,
			String description) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProductById(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
