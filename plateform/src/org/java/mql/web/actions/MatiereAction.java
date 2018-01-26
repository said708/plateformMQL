package org.java.mql.web.actions;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.java.mql.business.Module2Business;
import org.java.mql.models.Enseignant;
import org.java.mql.models.Matiere;
import org.primefaces.event.RowEditEvent;
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


	private List<Matiere> matieres;



	@PostConstruct
	public void init() {
		matieres = business.listeMatieres();

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

	
	public void onRowEdit(RowEditEvent event) {
		Matiere m = (Matiere)event.getObject();
		FacesMessage msg; 
		if(business.isAnMatiereExiste(m)){
			int status = business.updateMatiere(m) ;

			if(status == 1) {
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", m.getName() + " Updated with success");
			}else {
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
			}

		}else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Matiere Not exist !");   
		FacesContext.getCurrentInstance().addMessage(null, msg); 

	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((Matiere) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}




	public void delete(Matiere m) {
		FacesMessage msg; 
		if(business.isAnMatiereExiste(m)){
			Matiere status =  business.deleteMatiere(m);
			if(status !=null) {
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", m.getName() + " deleted with success");
			}else {
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
			}

		}else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Project not  exist |");   
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}
	

	public Matiere getMatiere() {
		return matiere;
	}


	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}
	
	public List<Enseignant> enseignants() {
		return business.listeEnseignants();
	}

}
