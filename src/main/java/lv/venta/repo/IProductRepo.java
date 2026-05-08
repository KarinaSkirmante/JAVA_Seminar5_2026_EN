package lv.venta.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Category;
import lv.venta.model.Product;

public interface IProductRepo 
		extends CrudRepository<Product, Integer> {

	/*~~(class org.openrewrite.java.tree.J$Erroneous cannot be cast to class org.openrewrite.java.tree.J$Assignment (org.openrewrite.java.tree.J$Erroneous and org.openrewrite.java.tree.J$Assignment are in unnamed module of loader 'app'))~~>*/@Query("SELECT p.id FROM Product p WHERE p.title = :title AND p.category = :category AND p.price = :price AND p.quantity = :quantity AND p.description = :description")
	boolean existsByTitleAndCategoryAndPriceAndQuantityAndDescription(String title, Category category, float price,
			int quantity, String description);
	//only abstract functions will be there

	ArrayList<Product> findByCategory(Category category);

	ArrayList<Product> findByPriceLessThan(float priceLevel);

	ArrayList<Product> findByTitleContainingOrDescriptionContaining(String keyword, String keyword2);

@Query(nativeQuery = true, value = "SELECT AVG(PRICE) FROM PRODUCT_TABLE;")
	float myCalculateAvgPrice();
}
