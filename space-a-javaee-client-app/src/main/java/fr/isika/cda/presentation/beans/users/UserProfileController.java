package fr.isika.cda.presentation.beans.users;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.users.UserAccount;

@ManagedBean
@ApplicationScoped
public class UserProfileController implements Serializable {

	/**
	 * 
	 */
	

	private static final long serialVersionUID = 536657576401406471L;


	@Inject
	private UserAccountRepository userAccountRepo;
	
	@Inject
	private UserLoginController userLoginController;
	
	public String data1;
	private String data2;


	public String showResult() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		data1 = params.get("username");
		data2 = params.get("test");
		return "/testPassParamOutput.xhtml?faces-redirect=true";
	}

	
	public String deleteProfile() {
		Long idToDelete = userLoginController.displayUserId();
		userAccountRepo.remove(idToDelete);
		userLoginController.Logout();
		return "/index.xhtml?faces-redirect=true";
	}
			
			
	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}


	public UserAccountRepository getUserAccountRepo() {
		return userAccountRepo;
	}


	public void setUserAccountRepo(UserAccountRepository userAccountRepo) {
		this.userAccountRepo = userAccountRepo;
	}
	

	
	
	
}
