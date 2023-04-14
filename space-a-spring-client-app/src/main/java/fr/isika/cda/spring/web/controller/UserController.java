package fr.isika.cda.spring.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.spring.business.service.UserAccountService;

@Controller
public class UserController {
	
	@Autowired
	private UserAccountService userAccountService;
	
	@RequestMapping("/edit")
	public ModelAndView editUserAccountForm(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("edit_userAccount");
		Optional<UserAccount> userAccount = userAccountService.byId(id);
		mav.addObject("userAccount", userAccount);
		return mav;
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUserAccountForm(@RequestParam Long id) {
		userAccountService.remove(id);
		return "redirect:/dashboard";
	}
	

}
