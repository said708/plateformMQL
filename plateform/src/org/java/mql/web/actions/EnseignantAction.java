package org.java.mql.web.actions;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.java.mql.business.Module2Business;
import org.java.mql.models.Enseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


@Component
@RequestScope
public class EnseignantAction {

	@Autowired
	private Module2Business business;

	@Autowired
	private Enseignant enseignant;

	public EnseignantAction() {
	}


	public void setBusiness(Module2Business business) {
		this.business = business;
	}

	public Module2Business getBusiness() {
		return business;
	}


	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	
	//services of enseignant
	public void addEnsignant() {
		FacesMessage msg; 
		if(!business.isAnEnseignantExiste(enseignant)){
			 int status =  business.addEnseignant(enseignant) ;
			 if(status == 1) {
				 msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", enseignant.getNom() + " added with success");
			 }else {
				 msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
			 }
			   
		}else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Enseignant already exist |");   
		FacesContext.getCurrentInstance().addMessage(null, msg); 
			
	}
	
	
	public List<Enseignant> listEnseignant(){
		return business.listeEnseignats();
	}

	

}
