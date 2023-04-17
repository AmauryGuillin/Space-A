package fr.isika.cda.presentation.beans.associations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.entities.association.services.Event;
import fr.isika.cda.entities.association.services.Publication;
import fr.isika.cda.entities.association.services.StuffToRent;
import fr.isika.cda.presentation.utils.SessionUtils;

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
	
	
	public String bookEvent(Long eventId) {
		
		//recup le user co
		Long userId = SessionUtils.getLoggedUserIdFromSession();
		
		//recup le matériel pour le modif
		Event event = assoRepo.findEventById(eventId);
		
		//modif le matos
		event.setIdUser(userId);
		
		//caler le matos en db
		assoRepo.updateEvent(event);
		
	return "/userProfile.xhtml?faces-redirect=true";
	}
	
	
	public List<Event> getUserBookedEvents(){
		List <Event> listAllEvent = assoRepo.findAllEvent();
		List <Event> listReturn = new ArrayList<>();
		
		Long userId = SessionUtils.getLoggedUserIdFromSession();
		
		for(Event event : listAllEvent) {
			
			if(event.getIdUser() == userId) {
				listReturn.add(event);
			}		
		}
		return listReturn;
	}
	
	

}
