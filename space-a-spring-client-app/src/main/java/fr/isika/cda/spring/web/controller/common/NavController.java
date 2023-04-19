package fr.isika.cda.spring.web.controller.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.subscriptions.AssoAdminSubscription;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.spring.business.service.AssociationSpaceService;
import fr.isika.cda.spring.business.service.SubscriptionService;
import fr.isika.cda.spring.business.service.UserAccountService;

@Controller
public class NavController {
	@Autowired
	private UserAccountService userAccountService;
	
	@Autowired
	private AssociationSpaceService associationSpaceService;
	
	@Autowired
	private SubscriptionService subscriptionService;

	@GetMapping("/")
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/esub")
	public String esub(Model model) {
		List<AssoAdminSubscription> subList = subscriptionService.all();
		model.addAttribute("subs", subList);
		return "edit_subscription.html";
	}

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<UserAccount> userList = userAccountService.all();
		List<Association> assoList = associationSpaceService.all();
		List<AssoAdminSubscription> subList = subscriptionService.all();
		model.addAttribute("users", userList);
		model.addAttribute("assos", assoList);
		model.addAttribute("subs", subList);
		return "dashboard.html";
	}
	
}
