package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Category;
import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;
import lv.venta.service.IProductFilterService;

@Service
public class ProductFilterServiceImpl implements IProductFilterService{

	@Autowired
	private IProductRepo prodRepo;
	
	
	@Override
	public ArrayList<Product> filterByCategory(Category category) throws Exception {
		if(category == null) {
			throw new Exception("Wrong input param");
		}
		ArrayList<Product> result = prodRepo.findByCategory(category);
		
		if(result.isEmpty()) {
			throw new Exception(
					"There are no products under category " + category);
		}
		else
		{
			return result;
		}
		
	}

	@Override
	public ArrayList<Product> filterByPrice(float priceLevel) throws Exception {
		if(priceLevel <= 0 || priceLevel > 100) {
			throw new Exception("Price level should be 0 - 100 eur");
		}
		ArrayList<Product> result = prodRepo.findByPriceLessThan(priceLevel);
		
		if(result.isEmpty()) {
			throw new Exception("There are no "
					+ "products which price is less than " + priceLevel);
		}
		else
		{
			return result;
		}
	}

	@Override
	public ArrayList<Product> filterByKeyword(String keyword) throws Exception {
		if(keyword == null || keyword.isEmpty()) {
			throw new Exception("Wrong input param");
		}
ArrayList<Product> result = 
prodRepo.findByTitleContainingOrDescriptionContaining(keyword, keyword);
	
if(result.isEmpty()) {
	throw new Exception("There are no "
			+ "products which title or description consist of " + keyword);
}
else
{
	return result;
}
	
	
	}

	@Override
	public float calculateAvgPrice() throws Exception {
	
		if(prodRepo.count() == 0) {
			throw new Exception("There are no products in DB"
					+ " and it is not possible to calculate avg price");
		}
		
		float result = prodRepo.myCalculateAvgPrice();
		
		return result;
	}

}
