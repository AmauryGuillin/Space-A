package fr.isika.cda.presentation.beans.navigation;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import fr.isika.cda.presentation.utils.WebUiTools;

@ManagedBean
@ApplicationScoped
public class NavController {

	public void assoForm() {
		WebUiTools.redirectToView("/createAsso.xhtml");
	}

	public void listAllAsso() {
		WebUiTools.redirectToView("/listAllAsso.xhtml");
	}

	public void users() {
		WebUiTools.redirectToView("/users.xhtml");
	}
	
	public void oneUser() {
		WebUiTools.redirectToView("/oneUser.xhtml");
	}

	public void index() {
		WebUiTools.redirectToView("/index.xhtml");
	}
	
	public void registrationUser() {
		WebUiTools.redirectToView("/registrationUser.xhtml");
	}
	
	public void userProfile() {
		WebUiTools.redirectToView("/userProfile.xhtml");
	}
	
	public void modifProfile() {
		WebUiTools.redirectToView("/modifProfile.xhtml");
	}

	public void login() {
		WebUiTools.redirectToView("/login.xhtml");
	}

	public void error() {
		WebUiTools.redirectToView("/error.xhtml");		
	}
	
	public void homeAsso() {
		WebUiTools.redirectToView("/homeAsso.xhtml");		
	}
	
	

}
