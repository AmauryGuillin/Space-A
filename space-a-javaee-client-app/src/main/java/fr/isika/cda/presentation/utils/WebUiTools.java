package fr.isika.cda.presentation.utils;

import java.io.IOException;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

public final class WebUiTools {
	
	private static final Logger LOGGER = Logger.getLogger(WebUiTools.class.getSimpleName());
	
	public static void redirectToView(final String viewName) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(viewName);
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
