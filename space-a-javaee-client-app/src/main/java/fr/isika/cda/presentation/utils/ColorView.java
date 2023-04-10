package fr.isika.cda.presentation.utils;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.colorpicker.ColorPicker;

@ManagedBean
public class ColorView {

	private String colorInlineOne;
	private String colorInlineTwo;
	private String colorInlineThree;
	private String colorPopup;



	public String getColorInlineOne() {
		return colorInlineOne;
	}

	public void setColorInlineOne(String colorInlineOne) {
		this.colorInlineOne = colorInlineOne;
	}

	public String getColorInlineTwo() {
		return colorInlineTwo;
	}

	public void setColorInlineTwo(String colorInlineTwo) {
		this.colorInlineTwo = colorInlineTwo;
	}

	public String getColorInlineThree() {
		return colorInlineThree;
	}

	public void setColorInlineThree(String colorInlineThree) {
		this.colorInlineThree = colorInlineThree;
	}

	public String getColorPopup() {
		return colorPopup;
	}

	public void setColorPopup(String colorPopup) {
		this.colorPopup = colorPopup;
	}

	public void onColorChange(AjaxBehaviorEvent e) {
		ColorPicker picker = (ColorPicker) e.getComponent();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Color changed: " + picker.getValue(), null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onPopupClosed(AjaxBehaviorEvent e) {
		ColorPicker picker = (ColorPicker) e.getComponent();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Popup closed: " + picker.getValue(), null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
