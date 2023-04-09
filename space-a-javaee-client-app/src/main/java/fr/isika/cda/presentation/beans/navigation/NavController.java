package fr.isika.cda.presentation.beans.navigation;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import fr.isika.cda.presentation.utils.WebUiTools;

@ManagedBean
@ApplicationScoped
public class NavController {

	public void assoForm() {
		WebUiTools.redirectToView("/assoManagement/createAsso.xhtml");
	}

	public void listAllAsso() {
		WebUiTools.redirectToView("/assoManagement/listAllAsso.xhtml");
	}

	public void users() {
		WebUiTools.redirectToView("/usersManagement/users.xhtml");
	}
	
	public void oneUser() {
		WebUiTools.redirectToView("/usersManagement/oneUser.xhtml");
	}

	public void index() {
		WebUiTools.redirectToView("/index.xhtml");
	}
	
	public void registrationUser() {
		WebUiTools.redirectToView("/usersManagement/registrationUser.xhtml");
	}
	
	public void userProfile() {
		WebUiTools.redirectToView("/usersManagement/userProfile.xhtml");
	}
	
	public void modifProfile() {
		WebUiTools.redirectToView("/usersManagement/modifProfile.xhtml");
	}

	public void login() {
		WebUiTools.redirectToView("/login.xhtml");
	}

	public void error() {
		WebUiTools.redirectToView("/error.xhtml");		
	}
	
	

}
