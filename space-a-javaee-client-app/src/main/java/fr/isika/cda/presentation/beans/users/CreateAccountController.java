package fr.isika.cda.presentation.beans.users;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.common.Address;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.entities.users.UserContact;
import fr.isika.cda.entities.users.UserProfile;
import fr.isika.cda.entities.users.UserRole;
import fr.isika.cda.entities.users.plannings.AccountPlanning;
import fr.isika.cda.presentation.beans.users.viewmodels.CreateAccountViewModel;

@ManagedBean
public class CreateAccountController {
	
	private CreateAccountViewModel createAccountViewModel = new CreateAccountViewModel();
	
	@Inject
	private UserAccountRepository accountRepository;
	
	public String createAccount() {
		UserAccount account = createAccountFromViewModel();
		accountRepository.createAccount(account);
		createAccountViewModel = new CreateAccountViewModel(); // Reset VM
		return "/index.xhtml?faces-redirect=true";
	}

	private UserAccount createAccountFromViewModel() {

		// Phone userPhone = new Phone();
		Address userAddress = new Address();

		UserContact userContact = new UserContact();
		userContact.setPrimaryEmail(createAccountViewModel.getPrimaryEmail());
		userContact.setAddress(userAddress);

		UserProfile userProfile = new UserProfile();
		userProfile.setUserContact(userContact);
		userProfile.setAvatar("user-avatar-basic.PNG");
		userProfile.setLastName("LastName");
		userProfile.setFirstName("FirstName");
		userProfile.setBirthday(new Date());
		
		
		AccountPlanning userPlanning = new AccountPlanning();

		UserAccount userAccount = new UserAccount()
			.withUsername(createAccountViewModel.getUsername())
			.withPassword(createAccountViewModel.getPassword())
			.withPrimaryRole(UserRole.USER)
			.withProfile(userProfile)
			.withAccountPlanning(userPlanning);
		
		userAccount.updateSelectedAssociation(1L);

		return userAccount;
	}
	
	//Getters & Setters

	public CreateAccountViewModel getCreateAccountViewModel() {
		return createAccountViewModel;
	}

	public void setCreateAccountViewModel(CreateAccountViewModel createAccountViewModel) {
		this.createAccountViewModel = createAccountViewModel;
	}

}
