package fr.isika.cda.presentation.beans.associations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.association.services.Event;
import fr.isika.cda.entities.association.services.Publication;
import fr.isika.cda.entities.association.services.StuffToRent;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.presentation.utils.SessionUtils;

@ManagedBean
public class EditEventController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4587102192121866929L;

	@Inject
	private AssociationRepository assoRepo;
	
	@Inject
	private UserAccountRepository userRepo;

	@Inject
	private UserAccountRepository userRepo;

	public List<Event> getAllEvent() {
		return assoRepo.findAllEvent();
	}

	public List<Event> getAllEventsOneAsso(){
		List <Event> listAllEvents = assoRepo.findAllEvent();
		List <Event> listReturn = new ArrayList<>();
		
		Long userId = SessionUtils.getLoggedUserIdFromSession();
		UserAccount user = userRepo.findByOneId(userId);
		
		for(Event event : listAllEvents) {
			
			if(event.getAssociation().getId() == user.getSelectedAssociation()) {
				listReturn.add(event);
			}		
		}
		return listReturn;
	}
	
	public String deleteEvent(Long eventId) {
		assoRepo.deleteEvent(eventId);
		return "/dashboardAdminEvt.xhtml?faces-redirect=true";
	}

	public String bookEvent(Long eventId) {

		// recup le user co
		Long userId = SessionUtils.getLoggedUserIdFromSession();
		UserAccount user = userRepo.findByOneId(userId);
		// recup le matériel pour le modif
		Event event = assoRepo.findEventByIdWithSubscribers(eventId);

		// modif le matos
		event.addSubscriber(user);

		// caler le matos en db
		assoRepo.updateEvent(event);

		return "/userProfile.xhtml?faces-redirect=true";
	}

	public List<Event> getUserBookedEvents() {
		List<Event> listAllEvent = assoRepo.findAllEventWithSubscribers();
		List<Event> listReturn = new ArrayList<>();

		Long userId = SessionUtils.getLoggedUserIdFromSession();
		UserAccount user = userRepo.findByOneId(userId);
		for (Event event : listAllEvent) {
			if (event.getSubscribers().contains(user)) {
				listReturn.add(event);
			}
		}
		return listReturn;
	}

	public List<String> getEventRegisteredUsers(Long eventId) {
		List<Long> registeredUsersIds = assoRepo.findAllUsersRegisteredToOneEvent(eventId);
		
		// get the list, stream liste d'infos, map : mappe chaque compte en username, collect transforme en liste
		List<String> registeredUsersNames = registeredUsersIds.stream()
				.map(id -> userRepo.findByOneId(id).getUsername())
				.collect(Collectors.toList());

//		// to be removed
//		registeredUsersNames.add("test 1");
//		registeredUsersNames.add("test 1");
//		registeredUsersNames.add("test 1");
//		registeredUsersNames.add("test 1");
//		registeredUsersNames.add("test 1");

		return registeredUsersNames;
	}
}

