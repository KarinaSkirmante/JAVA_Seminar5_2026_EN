package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	@GetMapping("/all/{id}")//localhost:8080/product/crud/all/2
	public String getControllerToGetOneProductById
	(@PathVariable(name = "id") int id, Model model) {
		
		try
		{
		Product productFromDB = prodService.retrieveProductById(id);
		model.addAttribute("box", productFromDB);
		return "product-page";
		}
		catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";
		}
		
	}
	
	@GetMapping("/one")//localhost:8080/product/crud/one?id=2
	public String getControllerToGetOneProductById2
	(@RequestParam(name = "id") int id, Model model) {
		try
		{
		Product productFromDB = prodService.retrieveProductById(id);
		model.addAttribute("box", productFromDB);
		return "product-page";
		}
		catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";
		}
	}

}
