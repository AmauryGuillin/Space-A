package fr.isika.cda.presentation.beans.users;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import fr.isika.cda.entities.association.Association;

@ManagedBean
@SessionScoped
public class TestPassParamAttribute implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -4025352727065721045L;

//	private String data = "1";
	private Association association;

	public void attributeListener(ActionEvent event) {
//		data = (String) event.getComponent().getAttributes().get("username");
		association = (Association) event.getComponent().getAttributes().get("asso");
	}


	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

}
