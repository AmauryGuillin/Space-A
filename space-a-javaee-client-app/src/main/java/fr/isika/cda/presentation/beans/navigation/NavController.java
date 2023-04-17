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
	
	public void contact() {
		WebUiTools.redirectToView("/contact.xhtml");
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
	
	public void events() {
		WebUiTools.redirectToView("/events.xhtml");
	}
	
	public void materials() {
		WebUiTools.redirectToView("/materials.xhtml");
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
	
	public void dashboardAdmin() {
		WebUiTools.redirectToView("/dashboardAdmin.xhtml");		
	}
	
	public void creationPubli() {
		WebUiTools.redirectToView("/creationPubli.xhtml");		
	}
	
	public void creationEvent() {
		WebUiTools.redirectToView("/creationEvent.xhtml");		
	}
	
	public void publiList() {
		WebUiTools.redirectToView("/publiList.xhtml");		
	}
	
	public void eventList() {
		WebUiTools.redirectToView("/eventList.xhtml");		
	}
	
	public void configSpace() {
		WebUiTools.redirectToView("/configSpace.xhtml");		
	}
	
	public void creationMatos() {
		WebUiTools.redirectToView("/creationMatos.xhtml");		
	}
	
	public void matosList() {
		WebUiTools.redirectToView("/matosList.xhtml");		
	}
	
	public void creationActivity() {
		WebUiTools.redirectToView("/creationActivity.xhtml");		
	}
	
	public void activityList() {
		WebUiTools.redirectToView("/activityList.xhtml");		
	}
	
	public void associationIndex() {
		//user
		//choper son assoSelect
		//asso : assoselect
		WebUiTools.redirectToView("/associationIndex.xhtml");		
	}
	
	public void dashboardAdminPub() {
		WebUiTools.redirectToView("/dashboardAdminPub.xhtml");	
	}
	
	public void dashboardAdminAct() {
		WebUiTools.redirectToView("/dashboardAdminAct.xhtml");	
	}
	
	public void dashboardAdminStuff() {
		WebUiTools.redirectToView("/dashboardAdminStuff.xhtml");	
	}
	
	public void dashboardAdminEvt() {
		WebUiTools.redirectToView("/dashboardAdminEvt.xhtml");	
	}
	
	

}
