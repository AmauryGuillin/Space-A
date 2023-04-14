package fr.isika.cda.presentation.beans.associations;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.entities.association.services.Event;
import fr.isika.cda.entities.association.services.Publication;

@ManagedBean
public class EditEventController implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4587102192121866929L;
	
	@Inject
	private AssociationRepository assoRepo;

	public List<Event> getAllEvent(){
		return assoRepo.findAllEvent();
	}
	
	public String deleteEvent(Long eventId) {
		assoRepo.deleteEvent(eventId);
		return "/eventList.xhtml?faces-redirect=true"; 
	}

}
