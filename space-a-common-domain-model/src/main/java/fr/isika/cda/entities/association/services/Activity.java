package fr.isika.cda.entities.association.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import fr.isika.cda.entities.association.Association;
import fr.isika.cda.entities.association.functionnality.ActivityType;
import fr.isika.cda.entities.users.UserAccount;

@Entity
public class Activity {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		
		private String title;
		
		private String description;
		
		private int maxCapacity;
		
//		private List<UserAccount> registeredList = new ArrayList<>();
		
		//private ActivityType activityType;
		
		private Date startDate;
		
		private Date endDate;

		
		@ManyToOne
		private Association association;


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public int getMaxCapacity() {
			return maxCapacity;
		}


		public void setMaxCapacity(int maxCapacity) {
			this.maxCapacity = maxCapacity;
		}


//		public List<UserAccount> getRegisteredList() {
//			return registeredList;
//		}
//
//
//		public void setRegisteredList(List<UserAccount> registeredList) {
//			this.registeredList = registeredList;
//		}


//		public ActivityType getActivityType() {
//			return activityType;
//		}
//
//
//		public void setActivityType(ActivityType activityType) {
//			this.activityType = activityType;
//		}


		public Date getStartDate() {
			return startDate;
		}


		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}


		public Date getEndDate() {
			return endDate;
		}


		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}


		public Association getAssociation() {
			return association;
		}


		public void setAssociation(Association association) {
			this.association = association;
		}


		public long getId() {
			return id;
		}
		
		

}
