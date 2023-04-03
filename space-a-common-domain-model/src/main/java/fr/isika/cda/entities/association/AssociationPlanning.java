package fr.isika.cda.entities.association;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.isika.cda.entities.assoService.Activity;
import fr.isika.cda.entities.assoService.Event;

@Entity
@Table(name = "association_description") 
public class AssociationPlanning {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int nbSlots;
	
	//getters setters, exception made on id setter
	
	public int getNbSlots() {
		return nbSlots;
	}
	public void setNbSlots(int nbSlots) {
		this.nbSlots = nbSlots;
	}
	public Long getId() {
		return id;
	}
	
	
	
	
	
}
