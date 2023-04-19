package fr.isika.cda.spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.isika.cda.spring.business.service.AssociationSpaceService;

@Controller
public class AssociationController {

	@Autowired
	private AssociationSpaceService associationSpaceService;
	
	@RequestMapping("/deleteAsso")
	public String deleteAssociationForm(@RequestParam Long id) {
		associationSpaceService.remove(id);
		return "redirect:/dashboard";
	}
	
}
