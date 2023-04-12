package fr.isika.cda.presentation.beans.navigation;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import fr.isika.cda.presentation.utils.WebUiTools;

@ManagedBean
@ApplicationScoped
public class NavController {

	public void createAsso() {
		WebUiTools.redirectToView("/createAsso.xhtml");
	}

	public void associations() {
		WebUiTools.redirectToView("/associations.xhtml");
	}

	public void users() {
		WebUiTools.redirectToView("/users.xhtml");
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
	
	public void updateProfile() {
		WebUiTools.redirectToView("/updateProfile.xhtml");
	}

	public void login() {
		WebUiTools.redirectToView("/login.xhtml");
	}

	public void error() {
		WebUiTools.redirectToView("/error.xhtml");		
	}
	
	public void associationIndex() {
		//user
		//choper son assoSelect
		//asso : assoselect
		WebUiTools.redirectToView("/associationIndex.xhtml");		
	}
	
	

}
