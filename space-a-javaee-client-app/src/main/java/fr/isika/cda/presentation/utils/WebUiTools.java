package fr.isika.cda.presentation.utils;

import java.io.IOException;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public final class WebUiTools {
	
	private static final Logger LOGGER = Logger.getLogger(WebUiTools.class.getSimpleName());
	
	/**
	 * Redirects to the given view name using the application context path:
	 * <br>
	 * Example : 
	 * <br>
	 * If viewName = "usersManagement/users.xhtml" <br> 
	 * => full path will be : 
	 * <br>
	 * <b>http://127.0.0.1:8080/space-a-javaee-client-app/</b>usersManagement/users.xhtml
	 * @param viewName
	 */
	public static void redirectToView(final String viewName) {
		try {
			String fullViewUrl = FacesContext.getCurrentInstance()
					.getExternalContext()
					.getRequestContextPath() + viewName;
			
			FacesContext.getCurrentInstance().getExternalContext().redirect(fullViewUrl);
		} catch (IOException e) {
			LOGGER.severe(String.format("Error redirecting to view : {%s} - {%s}", viewName, e.getMessage()));
		}	
	}
	
	public static void addMessageToComponent(final String uiComponentId, final String message) {
		UIComponent component = FacesContext.getCurrentInstance().getViewRoot().findComponent(uiComponentId);
		FacesContext.getCurrentInstance().addMessage(component.getClientId(), new FacesMessage(message));
	}
	
	private WebUiTools() {
	}
}
