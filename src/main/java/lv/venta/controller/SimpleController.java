package lv.venta.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
