package org.java.mql.web.actions;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.java.mql.business.Module2Business;
import org.java.mql.models.Enseignant;
import org.java.mql.models.Project;
import org.primefaces.event.RowEditEvent;
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
	
	
	private List<Enseignant> enseignants;

	
	@PostConstruct
	public void init() {
		enseignants = business.listeEnseignants();
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
	
	public void onRowEdit(RowEditEvent event) {
		Enseignant e = (Enseignant)event.getObject();
		FacesMessage msg; 
		if(business.isAnEnseignantExiste(e)){
			int status = business.updateEnseignant(e) ;

			if(status == 1) {
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", e.getNom() + " Updated with success");
			}else {
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
			}

		}else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Project already exist |");   
		FacesContext.getCurrentInstance().addMessage(null, msg); 

	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((Enseignant) event.getObject()).getNom());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}




	public void delete(Enseignant e) {
		FacesMessage msg; 
		if(business.isAnEnseignantExiste(e)){
			Enseignant status =  business.deleteEnseignant(e);
			if(status != null) {
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Enseignant "+e.getNom() + " deleted with success");
			}else {
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
			}

		}else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Project not  exist |");   
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}
	
	
	
	
	public List<Enseignant> getEnseignants() {
		return enseignants;
	}
	


	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	
	
	

}
