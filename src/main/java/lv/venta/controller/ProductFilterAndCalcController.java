package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Category;
import lv.venta.model.Product;
import lv.venta.service.IProductFilterService;

@Controller
@RequestMapping("/product/filter")
public class ProductFilterAndCalcController {

	@Autowired
	private IProductFilterService prodService;
	
	//localhost:8080/product/filter/category/fruits
	@GetMapping("/category/{category}")
	public String getControllerFilterByCategory(
			@PathVariable(name = "category") Category category,
			Model model) {
		try
		{
	ArrayList<Product> filterProdFromDB 
	= prodService.filterByCategory(category);
		model.addAttribute("box", filterProdFromDB);
		return "all-products-page";
	
		}catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";
		}
	}
	
	
	
	//localhost:8080/product/filter/price/4
		@GetMapping("/price/{price}")
		public String getControllerFilterByPrice(
				@PathVariable(name = "price") float price,
				Model model) {
			try
			{
		ArrayList<Product> filterProdFromDB 
		= prodService.filterByPrice(price);
			model.addAttribute("box", filterProdFromDB);
			return "all-products-page";
		
			}catch (Exception e) {
				model.addAttribute("box", e.getMessage());
				return "error-page";
			}
		}
		
		
		//localhost:8080/product/filter/keyword/sweet
				@GetMapping("/keyword/{keyword}")
				public String getControllerFilterBykeyword(
						@PathVariable(name = "keyword") String keyword,
						Model model) {
					try
					{
				ArrayList<Product> filterProdFromDB 
				= prodService.filterByKeyword(keyword);
					model.addAttribute("box", filterProdFromDB);
					return "all-products-page";
				
					}catch (Exception e) {
						model.addAttribute("box", e.getMessage());
						return "error-page";
					}
				}
				
				//localhost:8080/product/filter/price/avg
		@GetMapping("/price/avg") 
		public String getControllerCalculateAVGPrice(Model model) {
			try
			{
				float avgPrice = prodService.calculateAvgPrice();
				model.addAttribute("box", avgPrice);
				return "data-page";
			
			}catch (Exception e) {
				model.addAttribute("box", e.getMessage());
				return "error-page";
			}
		}
}
