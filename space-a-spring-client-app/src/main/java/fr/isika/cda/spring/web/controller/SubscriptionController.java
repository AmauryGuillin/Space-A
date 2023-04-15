package fr.isika.cda.spring.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.isika.cda.entities.association.subscriptions.AssoAdminSubscription;
import fr.isika.cda.spring.business.service.SubscriptionService;

@Controller
public class SubscriptionController {
	
	@Autowired
	private SubscriptionService subService;
	
	@RequestMapping("/editSub0000")
	public ModelAndView editSubScription(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("edit_subscription");
		Optional<AssoAdminSubscription> subscription = subService.byId(id);
		mav.addObject("subscription", subscription);
		return mav;
	}
	
	
	@RequestMapping("/delteSub")
	public String deleteSubscription(@RequestParam Long id) {
		subService.remove(id);
		return "redirect:/dashboard";
	}
	

}
