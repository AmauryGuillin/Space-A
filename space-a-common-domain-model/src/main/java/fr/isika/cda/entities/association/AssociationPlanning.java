package fr.isika.cda.entities.association;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "association_planning") 
public class AssociationPlanning {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nb_slots")
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
