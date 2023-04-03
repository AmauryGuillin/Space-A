package fr.isika.cda.business.services.users;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.business.exceptions.users.UserAccountCreationException;
import fr.isika.cda.business.exceptions.users.UserNotFoundException;
import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.entities.users.UserProfile;
import fr.isika.cda.presentation.beans.users.forms.UserCreationForm;

@Stateless
public class UserService {

	@Inject
	private UserAccountRepository userRepository;
	
	public void handle(UserCreationForm userCreationForm) throws UserAccountCreationException {
		try {
			validate(userCreationForm);
		} catch(UserNotFoundException e) {
			// Do nothing
		}
		save( mapFrom(userCreationForm) );
	}
	
	public List<UserAccount> all() {
		return userRepository.findAll();
	}
	
	private void save(UserAccount account) {
		userRepository.create(account);
	}

	private UserAccount mapFrom(UserCreationForm userCreationForm) {
		return new UserAccount()
				.withUsername(userCreationForm.getUsername())
				.withPassword(userCreationForm.getPassword())
				.withProfile(new UserProfile());
	}
	
	private void validate(UserCreationForm userCreationForm) throws UserAccountCreationException, UserNotFoundException {
		// Validation 1 : Check if user exists
		String username = userCreationForm.getUsername();
		Optional<UserAccount> optional = userRepository.findByUsername(username);
		if(!optional.isEmpty())
			throw new UserAccountCreationException(String.format("User account already exists (username :%s)", username));
	}
	
}
