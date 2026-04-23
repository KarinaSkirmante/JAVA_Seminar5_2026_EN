package lv.venta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {
	
	@GetMapping("/simple")//localhost:8080/simple
	public String getControllerSimple() {
		System.out.println("The simple controller is running");
		return "simple-page";//will show simple-page.html file
	}
}
