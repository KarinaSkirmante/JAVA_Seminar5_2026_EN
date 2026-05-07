package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Product;
import lv.venta.service.IProductCRUDService;

@Controller
@RequestMapping("/product/crud")
public class ProductCRUDController {
	
	@Autowired
	private IProductCRUDService prodService;
	
	@GetMapping("/all")//localhost:8080/product/crud/all
	public String getControllerToGetAllProducts(Model model) {

		try
		{
			ArrayList<Product> productsFromDB 
			= prodService.retrieveAllProducts();
			model.addAttribute("box", productsFromDB);
			return "all-products-page";
		}
		catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";
		}
	}

}
