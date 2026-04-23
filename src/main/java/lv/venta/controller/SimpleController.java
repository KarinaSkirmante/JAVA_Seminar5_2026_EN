package lv.venta.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.model.Category;
import lv.venta.model.Product;

@Controller
public class SimpleController {
	
	@GetMapping("/simple")//localhost:8080/simple
	public String getControllerSimple() {
		System.out.println("The simple controller is running");
		return "simple-page";//will show simple-page.html file
	}
	
	@GetMapping("/data")//localhost:8080/data
	public String getControllerData(Model model) {
		
		System.out.println("The data controller is running");
		
		Random random = new Random();
		String myData = "@ Karina, " + random.nextInt(2020, 2026);
		
		model.addAttribute("box", myData);
		return "data-page";//will show data-page.html file
		
	}
	
	@GetMapping("/product")//localhost:8080/product
	public String getControllerProduct(Model model) {
		System.out.println("The product controller is running");
		
		Product productData = 
		new Product(2, "Apple", Category.fruits, 0.99f, 3, "Red");
		
		model.addAttribute("box", productData);
		return "product-page";//will show product-page.html file
	}
	
	
	@GetMapping("/all-products")//localhost:8080/all-products
	public String getControllerAllProducts(Model model) {
		System.out.println("The all products controller is running");
		
		Product productData1 = 
			new Product(2, "Apple", Category.fruits, 0.99f, 3, "Red");
	
		Product productData2 = 
				new Product(1, "Grapes", Category.fruits, 1.99f, 2, "Green");

		Product productData3 = 
				new Product(3, "Watermelon", Category.fruits, 4.99f, 1, "Sweet");

		ArrayList<Product> allProducts = 
				new ArrayList<Product>
		(Arrays.asList(productData1, productData2, productData3));
		
		model.addAttribute("box", allProducts);
		return "all-products-page";//will show all-products-page.html file
	}
}
