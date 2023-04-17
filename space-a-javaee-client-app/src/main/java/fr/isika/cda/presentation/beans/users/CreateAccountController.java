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
		userProfile.setLastName("Nom");
		userProfile.setFirstName("Prenom");
		userProfile.setProfileDescription("Je suis un Chevalier Jedi talentueux, qui a grandi sur la planète Tatooine. Depuis mon plus jeune âge, j'ai été fasciné par la Force et ses mystères. J'ai été entraîné par le Maître Jedi Hossein, qui a reconnu mon potentiel et m'a pris sous son aile.\r\n"
				+ "\r\n"
				+ "En tant que Chevalier Jedi, j'ai participé à de nombreuses missions pour maintenir la paix dans la galaxie des associations. J'ai également participé à la Guerre des Clones, où j'ai démontré mes compétences en tant que pilote de chasseur stellaire et commandant de l'armée clone.\r\n"
				+ "\r\n"
				+ "Je suis déterminé à protéger la République et à défendre les valeurs de la Force associative. Malgré les défis auxquels je fais face, je suis convaincu que je peux réaliser de grandes choses en tant que Chevalier Jedi.");
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
