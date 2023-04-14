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
import fr.isika.cda.entities.association.functionnality.ConfigType;
import fr.isika.cda.entities.association.functionnality.EventType;
import fr.isika.cda.entities.association.functionnality.PublicationType;
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
        fontList = new ArrayList<>();
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
	
	public String updateAsso() {
		assoRepo.majAsso(asso);
		return "/dashboardAdmin.xhtml?faces-redirect=true";
	}
	
//EVENTS

	public void addEvent() {
		EventType event = createEventToVM();
		ConfigType configType = getOneAsso().getAssociationFunctionnality().getConfigType();
		assoRepo.addEventToAsso(configType.getId(), event);
	}
	
	private EventType createEventToVM() {
		EventType event = new EventType();
		event.setNameEventType(configTypeViewModel.getNameEventType());
		return event;
	}
	

	public List<EventType> getListEvents(){
		ConfigType configType = getOneAsso().getAssociationFunctionnality().getConfigType();
		return assoRepo.getAllEventsByConfigTypeId(configType.getId());
	}
	
//PUBLICATIONS
	
	public void addPublications() {
		PublicationType publi = createPubliToVM();
		ConfigType configType = getOneAsso().getAssociationFunctionnality().getConfigType();
		assoRepo.addPublicationToAsso(configType.getId(), publi);
	}
	
	private PublicationType createPubliToVM() {
		PublicationType publi = new PublicationType();
		publi.setNamePublicationType(configTypeViewModel.getNamePublicationType());
		return publi;
	}
	

	public List<PublicationType> getListPublications(){
		ConfigType configType = getOneAsso().getAssociationFunctionnality().getConfigType();
		return assoRepo.getAllPublicationByConfigTypeId(configType.getId());
	}

	public ConfigTypeViewModel getConfigTypeViewModel() {
		return configTypeViewModel;
	}
	
}
