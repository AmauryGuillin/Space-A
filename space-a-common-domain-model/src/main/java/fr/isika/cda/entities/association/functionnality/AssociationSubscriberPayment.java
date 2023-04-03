package fr.isika.cda.entities.association.functionnality;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asso_subscriber_payment")
public class AssociationSubscriberPayment {

	@Id
	@GeneratedValue
    private long id;
    private String deadline;//modif en objet quand class créé
    private String paymentType;//modif en objet quand class créé
    private String creditCardType;//modif en objet quand class créé
    
    
    
    // Getters and setters for all except id
    
    public long getId() {
        return id;
    }

    public String getDeadline() {
        return deadline;
    }
    
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    
    public String getPaymentType() {
        return paymentType;
    }
    
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    

    public String getCreditCardType() {
        return creditCardType;
    }
    
    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }
}
    

