package fr.isika.cda.entities.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "association_description") // VOIR AVEC ABI / AMAURY
public class AccountPlanning {

	@Id
	@GeneratedValue
	private Long id;

	
	// getter on id 
	public Long getId() {
		return id;
	}
	
	
	
}
