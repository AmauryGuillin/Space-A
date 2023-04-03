package fr.isika.cda.spring.web.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
}
