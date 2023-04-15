package fr.isika.cda.data.repositories.association;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.functionnality.ActivityType;
import fr.isika.cda.entities.association.functionnality.ConfigType;
import fr.isika.cda.entities.association.functionnality.EventType;
import fr.isika.cda.entities.association.functionnality.PublicationType;
import fr.isika.cda.entities.association.functionnality.RentingType;
import fr.isika.cda.entities.association.services.Activity;
import fr.isika.cda.entities.association.services.Event;
import fr.isika.cda.entities.association.services.Publication;
import fr.isika.cda.entities.association.services.StuffToRent;
import fr.isika.cda.entities.users.UserAccount;

@Stateless
public class AssociationRepository {

	private static final String CONFIG_TYPE_WITH_EVTS_BY_ID = "SELECT c FROM ConfigType c LEFT JOIN FETCH c.events WHERE c.id =:configTypeIdParam";

	private static final String CONFIG_TYPE_WITH_PUBLI_BY_ID = "SELECT c FROM ConfigType c LEFT JOIN FETCH c.publications WHERE c.id =:configTypeIdParam";

	
	private static final String CONFIG_TYPE_WITH_STUFF_BY_ID = "SELECT c FROM ConfigType c LEFT JOIN FETCH c.rentals WHERE c.id =:configTypeIdParam";
	

	@PersistenceContext
	private EntityManager entityManager;

	public Long createAsso(Association association) {
		entityManager.persist(association);
		return association.getId();
	}

	public List<Association> findAll() {
		return entityManager.createQuery("SELECT a FROM Association a", Association.class).getResultList();
	}

	public List<Publication> findAllPubli() {
		return entityManager.createQuery("SELECT p FROM Publication p", Publication.class).getResultList();
	}

	public Publication findPubliById(Long idPubli) {
		TypedQuery<Publication> query = entityManager.createQuery("SELECT p FROM Publication p WHERE p.id =: id",
				Publication.class);
		query.setParameter("id", idPubli);
		return query.getSingleResult();
	}

	public void deletePubli(Long publicationId) {
		Publication publi = findPubliById(publicationId);
		entityManager.remove(publi);
	}

	public Association findOneById(Long id) {
		TypedQuery<Association> query = entityManager.createQuery("SELECT a FROM Association a WHERE a.id = :id",
				Association.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	public Long majAsso(Association asso) {
		System.out.println(asso.getAssociationIdentity().getAssociationDepiction().getMainImage());
		Association mergedAsso = entityManager.merge(asso);
		entityManager.flush();
		return mergedAsso.getId();

	}

	public List<EventType> getAllEventsByConfigTypeId(Long configTypeId) {
		return getConfigTypeWithEvtsById(configTypeId).getEvents();
	}

	public List<PublicationType> getAllPublicationByConfigTypeId(Long configTypeId) {
		return getConfigTypeWithPubliById(configTypeId).getPublications();
	}
	
	public List<RentingType> getAllStuffByConfigTypeId(Long configTypeId) {
		return getConfigTypeWithStuffById(configTypeId).getRentals();
	}
	
	public void addEventToAsso(Long configTypeId, EventType event) {
		ConfigType configWithEvents = getConfigTypeWithEvtsById(configTypeId);
		configWithEvents.addEventType(event);
		entityManager.persist(event);
		entityManager.merge(configWithEvents);
	}

	public void addPublicationToAsso(Long configTypeId, PublicationType publi) {
		ConfigType configWithPublications = getConfigTypeWithPubliById(configTypeId);
		configWithPublications.addPublicationsType(publi);
		entityManager.persist(publi);
		entityManager.merge(configWithPublications);

	}
	
	public void addStuffToAsso(Long configTypeId, RentingType stuff) {
		ConfigType configWithStuff = getConfigTypeWithStuffById(configTypeId);
		configWithStuff.addRentingType(stuff);
		entityManager.persist(stuff);
		entityManager.merge(configWithStuff);
		
	}

	private ConfigType getConfigTypeWithEvtsById(Long configTypeId) {
		return entityManager.createQuery(CONFIG_TYPE_WITH_EVTS_BY_ID, ConfigType.class)
				.setParameter("configTypeIdParam", configTypeId).getSingleResult();
	}

	private ConfigType getConfigTypeWithPubliById(Long configTypeId) {
		return entityManager.createQuery(CONFIG_TYPE_WITH_PUBLI_BY_ID, ConfigType.class)
				.setParameter("configTypeIdParam", configTypeId).getSingleResult();
	}
	
	private ConfigType getConfigTypeWithStuffById(Long configTypeId) {
		return entityManager.createQuery(
				CONFIG_TYPE_WITH_STUFF_BY_ID, ConfigType.class)
				.setParameter("configTypeIdParam", configTypeId)
				.getSingleResult();
	}

	public Long createPubli(Publication publi) {
		entityManager.persist(publi);
		return publi.getId();
	}

	public Long createEvent(Event event) {
		entityManager.persist(event);
		return event.getId();
	}

	public void deleteEvent(Long eventId) {
		Event event = findEventById(eventId);
		entityManager.remove(event);
	}

	private Event findEventById(Long eventId) {
		TypedQuery<Event> query = entityManager.createQuery("SELECT e FROM Event e WHERE e.id =: id", Event.class);
		query.setParameter("id", eventId);
		return query.getSingleResult();
	}

	public List<Event> findAllEvent() {
		return entityManager.createQuery("SELECT e FROM Event e", Event.class).getResultList();
	}

	public List<StuffToRent> findAllMatos() {
		return entityManager.createQuery("SELECT m FROM StuffToRent m", StuffToRent.class).getResultList();
	}

	public void deleteMatos(Long matosId) {
		StuffToRent matos = findMatosById(matosId);
		entityManager.remove(matos);
	}

	public StuffToRent findMatosById(Long matosId) {
		TypedQuery<StuffToRent> query = entityManager.createQuery("SELECT m FROM StuffToRent m WHERE m.id =: id",
				StuffToRent.class);
		query.setParameter("id", matosId);
		return query.getSingleResult();
	}

	public Long createMatos(StuffToRent matos) {
		entityManager.persist(matos);
		return matos.getId();
	}

	public Long updateMatos(StuffToRent stuff) {
		StuffToRent mergedstuff = entityManager.merge(stuff);
	    entityManager.flush();
	    return mergedstuff.getId();

	}

	public Long createActivity(Activity activity) {
		entityManager.persist(activity);
		return activity.getId();
	}

	public List<ActivityType> getAllActivitiesByConfigTypeId(Long configTypeId) {
		return getConfigTypeWithEvtsById(configTypeId).getActivities();
	}

	public List<Activity> findAllActivities() {
		return entityManager.createQuery("SELECT a FROM Activity a", Activity.class).getResultList();
	}

	public void deleteActivity(Long activityId) {
		Activity activity = findActivityById(activityId);
		entityManager.remove(activity);
	}

	private Activity findActivityById(Long activityId) {
		TypedQuery<Activity> query = entityManager.createQuery("SELECT a FROM Activity a WHERE a.id =: id", Activity.class);
		query.setParameter("id", activityId);
		return query.getSingleResult();
	}



}
