package fr.isika.cda.entities.association;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "association_identity")
public class AssociationIdentity {
	
	@Id
	@GeneratedValue 
	private Long id; 
	
	private String headOffice;
	
	private String rscNumber; 
	
	private String kbisExtract;
	
	private String director; 
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private AssociationDepiction associationDepiction;
	
	public Long getId() {
		return id;
	}

	
	
	
	public String getHeadOffice() {
		return headOffice;
	}

	public void setHeadOffice(String headOffice) {
		this.headOffice = headOffice;
	}

	public String getRscNumber() {
		return rscNumber;
	}

	public void setRscNumber(String rscNumber) {
		this.rscNumber = rscNumber;
	}

	public String getKbisExtract() {
		return kbisExtract;
	}

	public void setKbisExtract(String kbisExtract) {
		this.kbisExtract = kbisExtract;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	

	
	

}
