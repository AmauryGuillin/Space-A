package fr.isika.cda.spring.business.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.spring.business.service.UserAccountService;

@Controller
public class UserController {
	
	@Autowired
	private UserAccountService userAccountService;
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		
		List<UserAccount> userList = userAccountService.all();
		model.addAttribute("userList", userList);
		return "dashboard.html";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editUserAccountForm(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("edit_userAccount");
		Optional<UserAccount> userAccount = userAccountService.byId(id);
		mav.addObject("userAccount", userAccount);
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteUserAccountForm(@RequestParam UserAccount userAccount) {
		userAccountService.remove(userAccount);
		return "redirect:/";
	}

}
