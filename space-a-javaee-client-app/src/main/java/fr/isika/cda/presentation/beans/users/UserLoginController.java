package fr.isika.cda.presentation.beans.users;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.entities.users.UserRole;
import fr.isika.cda.presentation.beans.navigation.NavController;
import fr.isika.cda.presentation.beans.users.viewmodels.UserLoginViewModel;

@ManagedBean
@SessionScoped
public class UserLoginController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1179088506634622925L;

	// Attributes
	
	@Inject
	private UserLoginViewModel userLoginViewModel = new UserLoginViewModel();
	
	@Inject
	private UserAccountRepository userAccountRepository;
	
	@Inject
	private NavController navController;
	
	private UserAccount userAccount;
	
	
	// Methodes
	
	public void show() {
		if(isUserLoggedIn()) {
			processLogin();
		}else {
			navController.login();
		}
	}
	
	public void login() {	
		try {	
		userAccount = userAccountRepository.findByOneName(userLoginViewModel.getUsername());
		if (userAccount != null && isUserLoggedIn() == false) {
			registerLoggedUserSessionAttributes(userAccount);
			processLogin();
			navController.index();
		} else if (isUserLoggedIn() == true) {
			navController.error();
		} else if (userAccount == null){
			navController.error();
		}
		resetViewModel();
		} catch (Exception e) {
			e.printStackTrace();
			navController.error();
		}
	}
	

	public void Logout() {
		resetViewModel();
		resetUserSessionAttributes();
		navController.index();
	}

	
	
	public void processLogin() {
		try {
			redirect(resolveViewNamedByUserRole());
		}catch(Exception e){
			navController.index();
		}
		
	}


	public boolean isUserLoggedIn() {
		return getLoggedUserIdFromSession()!=null;
	}
	
	public boolean hasAdminRole() {
		return UserRole.ADMIN.equals(getLoggedUserRoleFromSession());
	}
	
	public boolean hasMemberRole() {
		return UserRole.MEMBER.equals(getLoggedUserRoleFromSession());
	}
	
	public boolean hasUserRole() {
		return UserRole.USER.equals(getLoggedUserRoleFromSession());
	}
	
	public String resolvedLoggedUsername() {
		String usernameFromSession = getLoggedUsernameFromSession();
		return usernameFromSession != null ? usernameFromSession : "undefined";
	}
	
	private void redirect(String viewName) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(viewName);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String displayUserUsername() {
		String username = "";
		username = getLoggedUsernameFromSession();
		return username;
	}
	
	public Long displayUserId() {
		Long id = 0L;
		id = getLoggedUserIdFromSession();
		return id;
	}
	
	
	private String resolveViewNamedByUserRole() {
		UserRole roleFromSession = getLoggedUserRoleFromSession();
		switch (roleFromSession) {
		case USER:
			return "index.xhtml";
		case MEMBER:
			return "userProfile.xhtml";//TODO changer les view correspondant pour les 3 !!!
		case ADMIN:
			return "dashboardAdmin.xhtml";
		default:
			return "index.xhtml";
		}
		
	}
	
	public Long displayUserAssociationId() {
		Long id = 0L;
		id = getLoggedUserAssociationFromSession();
		return id;
	}
	
	private void resetViewModel() {
		this.userLoginViewModel = new UserLoginViewModel();
	}
	
	private HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}
	
	private void resetUserSessionAttributes() {
		HttpSession session = getSession();
		session.invalidate();
	}
	
	private Long getLoggedUserIdFromSession() {
		HttpSession session = getSession();
		return (Long) session.getAttribute("loggedUserId");
	}
	
	private String getLoggedUsernameFromSession() {
		HttpSession session = getSession();
		return (String) session.getAttribute("loggedUsername");
	}
	
	private UserRole getLoggedUserRoleFromSession() {
		HttpSession session = getSession();
		return (UserRole) session.getAttribute("loggedUserRole");
	}
	
	private Long getLoggedUserAssociationFromSession() {
		HttpSession session = getSession();
		return (Long) session.getAttribute("loggedAssociationId");
	}
	
	private void registerLoggedUserSessionAttributes(UserAccount userAccount) {
		HttpSession session = getSession();
		session.setAttribute("loggedUserId", userAccount.getUserId());
		session.setAttribute("loggedUsername", userAccount.getUsername());
		session.setAttribute("loggedUserRole", userAccount.getPrimaryRole());
		
		if (userAccount.getAssociation().getId() != null) {
			session.setAttribute("loggedAssociationId", userAccount.getAssociation().getId());
		}
		
	}
	
	
	//Getters and Setters

	public UserLoginViewModel getUserLoginViewModel() {
		return userLoginViewModel;
	}

	public void setUserLoginViewModel(UserLoginViewModel userLoginViewModel) {
		this.userLoginViewModel = userLoginViewModel;
	}

	public UserAccountRepository getUserAccountRepository() {
		return userAccountRepository;
	}

	public void setUserAccountRepository(UserAccountRepository userAccountRepository) {
		this.userAccountRepository = userAccountRepository;
	}

	public NavController getNavController() {
		return navController;
	}

	public void setNavController(NavController navController) {
		this.navController = navController;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	

}
