package org.java.mql.web.actions;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.java.mql.business.Module2Business;
import org.java.mql.models.Etudiant;
import org.java.mql.models.Team;
import org.primefaces.event.RowEditEvent;
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



	private List<Etudiant> students;
	private List<Etudiant> etudiantsNotAffected;


	@PostConstruct
	public void init() {
		students = business.listEtudiants();
		etudiantsNotAffected = business.listEtudiantsPasEncoreAffecter();
	}

	//services of Etudiant
	public void add() {
		FacesMessage msg; 
		int status =  business.addEtudiant(etudiant) ;
		if(status == 1) {
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", etudiant.getNom() + " added with success");
		}else {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
		}

		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}

	public void onRowEdit(RowEditEvent event) {
		Etudiant e = (Etudiant)event.getObject();
		FacesMessage msg; 
		int status = business.updateEtudiant(e) ;
		if(status == 1) {
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", e.getNom() + " Updated with success");
		}else {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg); 

	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((Etudiant) event.getObject()).toString());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}




	public void delete(Etudiant e) {
		FacesMessage msg; 
		Etudiant status =  business.deleteEtudiant(e);
		if(status != null) {
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Etudiant "+e.getNom() + " deleted with success");
		}else {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}


	public void addEtudiantToTeam(ActionEvent event) {
		Team team = (Team)event.getComponent().getAttributes().get("team");
		FacesMessage msg;
		etudiant.setTeam(team);
		int status = business.updateEtudiant(etudiant) ;
		if(status == 1) {
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", etudiant+ " Updated with success");
		}else {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}




	public List<Etudiant> getStudents() {
		return students;
	}



	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public List<Team> listTeams(){
		return business.listTeams();
	}

	public List<Etudiant> getEtudiantsNotAffected() {
		return etudiantsNotAffected;
	}



}
