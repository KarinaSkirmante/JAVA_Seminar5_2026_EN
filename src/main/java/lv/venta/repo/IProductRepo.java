package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Category;
import lv.venta.model.Product;

public interface IProductRepo 
		extends CrudRepository<Product, Integer> {

	boolean existsByTitleAndCategoryAndPriceAndQuantityAndDescription(String title, Category category, float price,
			int quantity, String description);
	//only abstract functions will be there
}
