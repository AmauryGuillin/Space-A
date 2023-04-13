package fr.isika.cda.presentation.beans.associations;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.functionnality.EventType;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.presentation.beans.associations.viewmodels.ConfigTypeViewModel;
import fr.isika.cda.presentation.beans.users.UserLoginController;


@ManagedBean
public class EditAssoComplete {

	private Association asso;
	private UserAccount userAccount;
	private Long userId;
	
	private ConfigTypeViewModel configTypeViewModel = new ConfigTypeViewModel();
	
	@Inject 
	private AssociationRepository assoRepo;
	
	@Inject 
	private UserAccountRepository userRepo;
	
	@Inject
	private UserLoginController userLoginController;
	
	private List<SelectItem> fontList;
	
	@PostConstruct
    public void init() {
        fontList = new ArrayList<SelectItem>();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = ge.getAllFonts();
        for (Font font : fonts) {
            fontList.add(new SelectItem(font.getFontName()));
        }
    }

    public List<SelectItem> getFontList() {
        return fontList;
    }
	
	public Association getOneAsso() {
		if (userAccount == null) {
			userId = userLoginController.displayUserId();
			userAccount = userRepo.findByOneId(userId);
			asso = assoRepo.findOneById(userAccount.getAssociation().getId());
		}
		return asso;
	}

	public String addEvent() {
		Association asso = getOneAsso();
		System.out.println("ASSO : " + asso);
		
		EventType event = createEventToVM();
		System.out.println("EVENT : " + event);
		
		
		assoRepo.addEventToAsso(asso, event);
		
//		asso.getAssociationFunctionnality().getConfigType().addEventType(event);
//		assoRepo.majAsso(asso);
		return "/index.xhtml?faces-redirect=true";
	}
	
	public EventType createEventToVM() {
		EventType event = new EventType();
		System.out.println("event dans VM" + configTypeViewModel.getNameEventType());
		event.setNameEventType(configTypeViewModel.getNameEventType());
		
		return event;
	}
	
	public String updateAsso() {
		assoRepo.majAsso(asso);
		return "/index.xhtml?faces-redirect=true";
	}
	
//	public List<EventType> getListEvents(){
//		
//		//je récupère l'asso 
//		Association asso = getOneAsso();
//		//je récupère la liste des types d'event
//		List<EventType> listEvent = asso.getAssociationFunctionnality().getConfigType().getEvents();
//		
//		
//		return listEvent;
//	}

	public ConfigTypeViewModel getConfigTypeViewModel() {
		return configTypeViewModel;
	}
	
	
	
}
