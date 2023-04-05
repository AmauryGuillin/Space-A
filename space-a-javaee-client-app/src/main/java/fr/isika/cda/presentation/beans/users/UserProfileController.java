package fr.isika.cda.presentation.beans.users;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.users.UserAccountRepository;

@ManagedBean
public class UserProfileController implements Serializable{
	
	private String username;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 536657576401406471L;
	
	
	
	@Inject
	private UserAccountRepository userAccountRepository;



	
	
	
	
	
	
	
	// Getters & Setters

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
	
	

}
