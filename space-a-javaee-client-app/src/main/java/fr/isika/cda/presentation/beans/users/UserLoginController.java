package fr.isika.cda.presentation.beans.users;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.entities.users.UserRole;
import fr.isika.cda.presentation.beans.navigation.NavController;
import fr.isika.cda.presentation.beans.users.viewmodels.UserLoginViewModel;
import fr.isika.cda.presentation.utils.SessionUtils;
import fr.isika.cda.presentation.utils.WebUiTools;

@ManagedBean
@SessionScoped
public class UserLoginController implements Serializable {

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
		if (isUserLoggedIn()) {
			processLogin();
		} else {
			navController.login();
		}
	}

	public void login() {

		userAccount = userAccountRepository.findByOneName(userLoginViewModel.getUsername());
		if(userAccount == null) {
			navController.error();
			return;
		}
		
		try {
			if (!isUserLoggedIn()) {
				SessionUtils.registerLoggedUserSessionAttributes(userAccount);
				processLogin();
				navController.index();
			}
			resetViewModel();
		} catch (Exception e) {
			navController.error();
		}
	}

	public void logout() {
		resetViewModel();
		SessionUtils.resetUserSessionAttributes();
		navController.index();
	}

	public void processLogin() {
		try {
			WebUiTools.redirectToView( resolveViewNamedByUserRole() );
		} catch (Exception e) {
			navController.index();
		}
	}
	
	public boolean isUserLoggedIn() {
		return SessionUtils.getLoggedUserIdFromSession() != null;
	}

	public boolean hasAdminRole() {
		return UserRole.ADMIN.equals(SessionUtils.getLoggedUserRoleFromSession());
	}

	public boolean hasMemberRole() {
		return UserRole.MEMBER.equals(SessionUtils.getLoggedUserRoleFromSession());
	}

	public boolean hasUserRole() {
		return UserRole.USER.equals(SessionUtils.getLoggedUserRoleFromSession());
	}

	public String resolvedLoggedUsername() {
		String usernameFromSession = SessionUtils.getLoggedUsernameFromSession();
		return usernameFromSession != null ? usernameFromSession : "undefined";
	}

	public String displayUserUsername() {
		return SessionUtils.getLoggedUsernameFromSession();
	}

	public Long displayUserId() {
		return SessionUtils.getLoggedUserIdFromSession();
	}

	private String resolveViewNamedByUserRole() {
		UserRole roleFromSession = SessionUtils.getLoggedUserRoleFromSession();
		switch (roleFromSession) {
		case USER:
			return "/index.xhtml";
		case MEMBER:
			// TODO changer les view correspondant pour les 3 !!!
			return "/userProfile.xhtml";
		case ADMIN:
			return "/dashboardAdmin.xhtml";
		default:
			return "/index.xhtml";
		}
	}

	private void resetViewModel() {
		this.userLoginViewModel = new UserLoginViewModel();
	}

	// Getters and Setters

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
