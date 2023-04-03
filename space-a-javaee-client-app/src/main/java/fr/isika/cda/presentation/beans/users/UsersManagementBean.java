package fr.isika.cda.presentation.beans.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import fr.isika.cda.business.services.users.UserService;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.entities.users.UserRole;

@Named
@ViewScoped
public class UsersManagementBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5051221574794695640L;

	@Inject
	private UserService userService;
	
	@Inject
	private CreateUserAccountManagedBean createUserAccountManagedBean;
	
	private List<UserAccount> users = new ArrayList<>();
	private List<UserAccount> selectedUsers = new ArrayList<>();
	
	@PostConstruct
	private void init() {
		users = userService.all();
	}
	
	/**
	 * UI
	 */
	public void openNew() {
		createUserAccountManagedBean.openNew();
    }
	
	/**
	 * Event
	 * @param account
	 */
	public void onUserAccountCreation(@Observes(notifyObserver = Reception.IF_EXISTS) final UserAccount account) {
		users = userService.all();
    }
	
	/**
	 * Event
	 * @param event
	 */
	public void onRowEdit(RowEditEvent<UserAccount> event) {
        FacesMessage msg = new FacesMessage("UserAccount Edited", String.valueOf(event.getObject().getUserId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * Event
     * @param event
     */
    public void onRowCancel(RowEditEvent<UserAccount> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", String.valueOf(event.getObject().getUserId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    /**
     * Event
     * @param event
     */
    public void onCellEdit(@SuppressWarnings("rawtypes") CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
	
	public List<UserAccount> getUsers() {
		return users;
	}
	public void setUsers(List<UserAccount> users) {
		this.users = users;
	}
	public List<UserAccount> getSelectedUsers() {
		return selectedUsers;
	}
	public void setSelectedUsers(List<UserAccount> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}
	public UserRole[] userRoles() {
		return UserRole.values();
	}
}
