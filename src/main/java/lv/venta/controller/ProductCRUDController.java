package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lv.venta.model.Product;
import lv.venta.service.IProductCRUDService;

@Controller
@RequestMapping("/product/crud")
public class ProductCRUDController {

	@Autowired
	private IProductCRUDService prodService;

	@GetMapping("/all") // localhost:8080/product/crud/all
	public String getControllerToGetAllProducts(Model model) {

		try {
			ArrayList<Product> productsFromDB = prodService.retrieveAllProducts();
			model.addAttribute("box", productsFromDB);
			return "all-products-page";
		} catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";
		}
	}

	@GetMapping("/all/{id}") // localhost:8080/product/crud/all/2
	public String getControllerToGetOneProductById(@PathVariable(name = "id") int id, Model model) {

		try {
			Product productFromDB = prodService.retrieveProductById(id);
			model.addAttribute("box", productFromDB);
			return "product-page";
		} catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";
		}

	}

	@GetMapping("/one") // localhost:8080/product/crud/one?id=2
	public String getControllerToGetOneProductById2(@RequestParam(name = "id") int id, Model model) {
		try {
			Product productFromDB = prodService.retrieveProductById(id);
			model.addAttribute("box", productFromDB);
			return "product-page";
		} catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";
		}
	}

	@GetMapping("/delete/{id}") // localhost:8080/product/crud/delete/2
	public String getControllerForDeleteProductById(@PathVariable(name = "id") int id, Model model) {

		try {
			prodService.deleteProductById(id);

			ArrayList<Product> productsFromDB = prodService.retrieveAllProducts();
			model.addAttribute("box", productsFromDB);
			return "all-products-page";
		} catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";
		}
	}

	@GetMapping("/add") // localhost:8080/product/crud/add
	public String getControllerForProductAdd(Model model) {
		model.addAttribute("product", new Product());// empty products is passed
		return "add-product-page";
	}

	@PostMapping("/add")
	public String postControllerForProductAdd(@Valid Product product,
			BindingResult problems, Model model) {

		// this will check if there is any problem with data validation
		if (problems.hasErrors()) {
			return "add-product-page";
		} else {
			try {
				prodService.createProduct(product.getTitle(), product.getCategory(), product.getPrice(),
						product.getQuantity(), product.getDescription());

				return "redirect:/product/crud/all";
			} catch (Exception e) {
				model.addAttribute("box", e.getMessage());
				return "error-page";
			}
		}
	}

	@GetMapping("/update/{id}") // localhost:8080/product/crud/update/2
	public String getControllerForProductUpdateById(@PathVariable(name = "id") int id, Model model) {

		try {
			Product productFromDB = prodService.retrieveProductById(id);
			model.addAttribute("product", productFromDB);
			return "update-product-page";

		} catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";
		}
	}

	//TODO added also validation part here. Take a look to postMapping add example
	@PostMapping("/update/{id}")
	public String postControllerForProductUpdateById(@PathVariable(name = "id") int id, Model model, Product product) {
		try {
			prodService.updateProductById(id, product.getTitle(), product.getCategory(), product.getPrice(),
					product.getQuantity(), product.getDescription());

			return "redirect:/product/crud/all";

		} catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";
		}
	}

}
