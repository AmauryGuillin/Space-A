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
	private Long id;//J'AI RAJOUTER CA
	private String legalName;
	private String registrationNumber;
	
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
	
//GraphicChart
	private String mainColor;
	private String secondaryColor;
	private String tertaryColor;	
	private String font;
//	private String banner;
	
//getters and setters
	
	
	
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMainColor() {
		return mainColor;
	}

	public void setMainColor(String mainColor) {
		this.mainColor = mainColor;
	}

	public String getSecondaryColor() {
		return secondaryColor;
	}

	public void setSecondaryColor(String secondaryColor) {
		this.secondaryColor = secondaryColor;
	}

	public String getTertaryColor() {
		return tertaryColor;
	}

	public void setTertaryColor(String tertaryColor) {
		this.tertaryColor = tertaryColor;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

//	public String getBanner() {
//		return banner;
//	}
//
//	public void setBanner(String banner) {
//		this.banner = banner;
//	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}


	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
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
