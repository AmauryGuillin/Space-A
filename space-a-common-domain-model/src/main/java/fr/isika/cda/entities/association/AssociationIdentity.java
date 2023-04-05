package fr.isika.cda.entities.association;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.isika.cda.entities.common.Address;

@Entity
@Table(name = "association_identity")
public class AssociationIdentity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Address headOffice;

	@Column(name="rcs_number", length = 18, unique = true, nullable = true)
	private String rscNumber;//String car ex : "RCS Lyon 123456789"

	@Column(name="kbis_extract")
	private String kbisExtract;

	@Column(length = 18, nullable = true)
	private String director;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private AssociationDepiction associationDepiction;

	public Long getId() {
		return id;
	}

	public AssociationDepiction getAssociationDepiction() {
		return associationDepiction;
	}

	public void setAssociationDepiction(AssociationDepiction associationDepiction) {
		this.associationDepiction = associationDepiction;
	}

	public Address getHeadOffice() {
		return headOffice;
	}

	public void setHeadOffice(Address headOffice) {
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
