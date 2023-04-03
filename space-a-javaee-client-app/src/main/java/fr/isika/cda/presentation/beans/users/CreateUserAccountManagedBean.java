package fr.isika.cda.presentation.beans.users;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import fr.isika.cda.business.exceptions.users.UserAccountCreationException;
import fr.isika.cda.business.services.users.UserService;
import fr.isika.cda.presentation.beans.users.forms.UserCreationForm;
import fr.isika.cda.presentation.utils.WebUiTools;

@Named(value = "createUserBean")
@ViewScoped
public class CreateUserAccountManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8174549242665123337L;

	@Inject
	private UserService userService;

	private UserCreationForm userCreationForm = new UserCreationForm();

	public void create() {
		try {
			userService.handle(userCreationForm);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User Account added"));

	        PrimeFaces.current().executeScript("PF('manageUserAccountDialog').hide()");
	        PrimeFaces.current().ajax().update("usersManagementTableForm:msgs", "usersManagementTableForm:users-dt");
			
		} catch (UserAccountCreationException e) {
			WebUiTools.addMessageToComponent("dialogs:manage-user-accounts-content", "Error creating a new account");
		}
	}

	public void openNew() {
		this.userCreationForm = new UserCreationForm();
	}
	
	public UserCreationForm getUserCreationForm() {
		return userCreationForm;
	}
	public void setUserCreationForm(UserCreationForm userCreationForm) {
		this.userCreationForm = userCreationForm;
	}
	
}
