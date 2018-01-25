package org.java.mql.web.actions;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.java.mql.business.Module2Business;
import org.java.mql.models.Enseignant;
import org.java.mql.models.Matiere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


@Component
@RequestScope
public class MatiereAction {

	@Autowired
	private Module2Business business;

	@Autowired
	private Matiere matiere;



	public MatiereAction() {
//		System.out.println("salam");
	}


	public void setBusiness(Module2Business business) {
		this.business = business;
	}

	public Module2Business getBusiness() {
		return business;
	}






	

	public Matiere getMatiere() {
		return matiere;
	}


	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}


	public void addMatiere() {
		FacesMessage msg; 
		int status = business.addMatiere(matiere);
		if(status == 1) {
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", matiere.getName() + " added with success");   
		}else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");   
		FacesContext.getCurrentInstance().addMessage(null, msg); 
		System.out.println(matiere.getEnseignant());
	}

	public List<Enseignant> listEnseignants(){
		return business.listeEnseignats();
	}

}
