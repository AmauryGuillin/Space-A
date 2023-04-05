package fr.isika.cda.presentation.beans.associations.viewmodels;

import java.io.Serializable;

import fr.isika.cda.entities.common.Address;

public class AssociationViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6317010007780395512L;

	/*
	 * Required
	 */
//Association	
	private String legalName;
	private int registrationNumber;
	
//Depiction
	private String name;
    private String description;
    private String logo;
    private String mainImage; 
	
//Identity
    private String headOffice;
	private String rscNumber;
	private String kbisExtract;
	private String director;
	
//getters and setters
	
	public String getLegalName() {
		return legalName;
	}
	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getMainImage() {
		return mainImage;
	}
	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public int getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
}
