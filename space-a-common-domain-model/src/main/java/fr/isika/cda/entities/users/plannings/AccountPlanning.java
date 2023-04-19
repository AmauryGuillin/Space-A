package fr.isika.cda.entities.users.plannings;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "association_description") // VOIR AVEC ABI / AMAURY
public class AccountPlanning {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	// getter on id 
	public Long getId() {
		return id;
	}
	
	
	
}
