package fr.isika.cda.presentation.beans.users;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UserProfileController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 536657576401406471L;

	public String data1 = "1";
	public String data2 = "1";


	public String showResult() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		data1 = params.get("username");
		data2 = params.get("test");
		return "/testPassParamOutput.xhtml?faces-redirect=true";
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
	

}
