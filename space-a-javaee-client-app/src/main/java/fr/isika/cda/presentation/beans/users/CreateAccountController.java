package fr.isika.cda.presentation.beans.users;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.users.AccountRepository;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.entities.users.UserContact;
import fr.isika.cda.presentation.beans.associations.viewmodels.CreateAccountViewModel;

@ManagedBean
public class CreateAccountController {
	
	private CreateAccountViewModel createAccountViewModel = new CreateAccountViewModel();
	
	@Inject
	private AccountRepository accountRepository;
	
	public String createAccount() {
		UserAccount account = createAccountFromViewModel();
		accountRepository.createAccount(account);
		createAccountViewModel = new CreateAccountViewModel(); // Reset VM
		return "/index.xhtml?faces-redirect=true";
	}

	private UserAccount createAccountFromViewModel() {
		
		if (createAccountViewModel.getPassword().equals(createAccountViewModel.getPasswordControl())) {
			
			UserContact userContact = new UserContact();
			userContact.setPrimaryEmail(createAccountViewModel.getPrimaryEmail());
			
			UserAccount userAccount = new UserAccount();
			userAccount.setUsername(createAccountViewModel.getUsername());
			userAccount.setPassword(createAccountViewModel.getPassword());
			
			return userAccount;
		} else {
			System.err.println("mot de passe incorrect");
			return null;
		}
		
		
	}
	
	
	
	
	//Getters & Setters

	public CreateAccountViewModel getCreateAccountViewModel() {
		return createAccountViewModel;
	}

	public void setCreateAccountViewModel(CreateAccountViewModel createAccountViewModel) {
		this.createAccountViewModel = createAccountViewModel;
	}

	public AccountRepository getAccountRepository() {
		return accountRepository;
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	

}
