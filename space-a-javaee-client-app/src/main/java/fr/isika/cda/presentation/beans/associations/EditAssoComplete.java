package fr.isika.cda.presentation.beans.associations;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import fr.isika.cda.data.repositories.association.AssociationRepository;
import fr.isika.cda.data.repositories.users.UserAccountRepository;
import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.functionnality.ActivityType;
import fr.isika.cda.entities.association.functionnality.ConfigType;
import fr.isika.cda.entities.association.functionnality.EventType;
import fr.isika.cda.entities.association.functionnality.PublicationType;
import fr.isika.cda.entities.association.functionnality.RentingType;
import fr.isika.cda.entities.association.services.StuffToRent;
import fr.isika.cda.entities.users.UserAccount;
import fr.isika.cda.presentation.beans.associations.viewmodels.ConfigTypeViewModel;
import fr.isika.cda.presentation.beans.users.UserLoginController;
import fr.isika.cda.presentation.utils.FileUpload;


@ManagedBean
@ViewScoped
public class EditAssoComplete {

	private Association asso;
	private UserAccount userAccount;
	private Long userId;
	private String mainImage;
	private String logoImage;
	private String kbisExtract;
	
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
        asso = getOneAsso();
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
		if (mainImage != null) {
			asso.getAssociationIdentity().getAssociationDepiction().setMainImage(mainImage);
		}
		if (logoImage != null) {
			asso.getAssociationIdentity().getAssociationDepiction().setLogo(logoImage);
		}
		if (kbisExtract != null) {
			asso.getAssociationIdentity().setKbisExtract(kbisExtract);
		}
		assoRepo.majAsso(asso);
		return "/dashboardAdmin.xhtml?faces-redirect=true";
	}
	
	public String updateAssoColor() {
		if (mainImage != null) {
			asso.getAssociationIdentity().getAssociationDepiction().setMainImage(mainImage);
		}
		if (logoImage != null) {
			asso.getAssociationIdentity().getAssociationDepiction().setLogo(logoImage);
		}
		if (kbisExtract != null) {
			asso.getAssociationIdentity().setKbisExtract(kbisExtract);
		}
		assoRepo.majAsso(asso);
		return "/configSpace.xhtml?faces-redirect=true";
	}

	public ConfigTypeViewModel getConfigTypeViewModel() {
		return configTypeViewModel;
	}

	public void uploadKbisExtract(FileUploadEvent event) {	
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMYYYY_hhmmss"));
		UploadedFile file = event.getFile();
		kbisExtract = timestamp + "_" + file.getFileName();
		FileUpload.doUpload(file, kbisExtract);
	}
	
	public void uploadLogoImage(FileUploadEvent event) {
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMYYYY_hhmmss"));
		UploadedFile file = event.getFile();
		logoImage = timestamp + "_" + file.getFileName();
		FileUpload.doUpload(file, logoImage);
	}
	
	public void uploadMainImage(FileUploadEvent event) {
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMYYYY_hhmmss"));
		UploadedFile file = event.getFile();
		mainImage = timestamp + "_" + file.getFileName();
		FileUpload.doUpload(file, mainImage);
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
	
//STUFF

	public void addStuff() {
		RentingType stuff = createStuffToVM();
		ConfigType configType = getOneAsso().getAssociationFunctionnality().getConfigType();
		assoRepo.addStuffToAsso(configType.getId(), stuff);
	}
	
	private RentingType createStuffToVM() {
		RentingType stuff = new RentingType();
		stuff.setNameRentingType(configTypeViewModel.getNameStuffType());
		return stuff;
	}
	

	public List<RentingType> getListStuffs(){
		ConfigType configType = getOneAsso().getAssociationFunctionnality().getConfigType();
		return assoRepo.getAllStuffByConfigTypeId(configType.getId());
	}

	//ACTIVITIES

		public void addActivity() {
			ActivityType activity = createActivityToVM();
			ConfigType configType = getOneAsso().getAssociationFunctionnality().getConfigType();
			assoRepo.addActivityToAsso(configType.getId(), activity);
		}
		
		private ActivityType createActivityToVM() {
			ActivityType activity = new ActivityType();
			activity.setNameActivityType(configTypeViewModel.getNameActivityType());
			return activity;
		}
		

		public List<ActivityType> getListActivities(){
			ConfigType configType = getOneAsso().getAssociationFunctionnality().getConfigType();
			return assoRepo.getAllActivitiesByConfigTypeId(configType.getId());
		}
}
