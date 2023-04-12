package fr.isika.cda.presentation.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.entities.users.UserRole;

public final class SessionUtils {

	public static final Long getLoggedUserIdFromSession() {
		HttpSession session = getSession();
		return (Long) session.getAttribute("loggedUserId");
	}
	
	private static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}
	
	public static void resetUserSessionAttributes() {
		HttpSession session = getSession();
		session.invalidate();
	}
	
	public static String getLoggedUsernameFromSession() {
		HttpSession session = getSession();
		return (String) session.getAttribute("loggedUsername");
	}
	
	public static UserRole getLoggedUserRoleFromSession() {
		HttpSession session = getSession();
		return (UserRole) session.getAttribute("loggedUserRole");
	}
	
	public static void registerLoggedUserSessionAttributes(UserAccount userAccount) {
		HttpSession session = getSession();
		session.setAttribute("loggedUserId", userAccount.getUserId());
		session.setAttribute("loggedUsername", userAccount.getUsername());
		session.setAttribute("loggedUserRole", userAccount.getPrimaryRole());	
	}

	private SessionUtils() {
	}

}
