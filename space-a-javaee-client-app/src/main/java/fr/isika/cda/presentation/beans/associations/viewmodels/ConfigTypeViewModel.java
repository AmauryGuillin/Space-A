package fr.isika.cda.presentation.beans.associations.viewmodels;

import java.io.Serializable;

public class ConfigTypeViewModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4992058143606306382L;

		private String nameEventType;

		private String namePublicationType;
		
		private String nameStuffType;
		
		public String getNameEventType() {
			return nameEventType;
		}

		public void setNameEventType(String nameEventType) {
			this.nameEventType = nameEventType;
		}

		public String getNamePublicationType() {
			return namePublicationType;
		}

		public void setNamePublicationType(String namePublicationType) {
			this.namePublicationType = namePublicationType;
		}

		public String getNameStuffType() {
			return nameStuffType;
		}

		public void setNameStuffType(String nameStuffType) {
			this.nameStuffType = nameStuffType;
		}
		
		
	

	
	
}
