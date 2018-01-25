package org.java.mql.web.actions;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.java.mql.business.Module2Business;
import org.java.mql.models.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


@Component
@RequestScope
public class EtudiantAction {

	@Autowired
	private Module2Business business;

	@Autowired
	private Etudiant etudiant;



	public EtudiantAction() {
	}


	public void setBusiness(Module2Business business) {
		this.business = business;
	}

	public Module2Business getBusiness() {
		return business;
	}
	
	public void add() {
		FacesMessage msg; 
		int status = business.addEtudiant(etudiant);
		if(status == 1) {
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", etudiant.getNom() + " added with success");   
		}else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");   
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}
	
	
	public void delete() {
		business.deleteEtudiant(etudiant.getId());
	};
	
	
	
	public List<Etudiant> allEtudiants(){
		return business.listEtudiants();
	}
	
	
	
	public void addListEtudiants() {
		
	}

	

}
