package fr.isika.cda.presentation.beans.users;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.users.AccountRepository;
import fr.isika.cda.presentation.beans.users.viewmodels.UserLoginViewModel;

@ManagedBean
@SessionScoped
public class UserLoginController {
	
	
	private UserLoginViewModel userLoginViewModel = new UserLoginViewModel();
	
	@Inject
	private AccountRepository accountRepository;
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	

}
