package org.java.mql.web.actions;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.java.mql.business.Module2Business;
import org.java.mql.models.Etudiant;
import org.java.mql.models.Matiere;
import org.java.mql.models.Project;
import org.java.mql.models.Team;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;


@Component
@ApplicationScope
public class TeamAction {

	@Autowired
	private Module2Business business;

	@Autowired
	private Team team;

	private List<Team> teams;

	@PostConstruct
	public void init() {
		teams = business.listTeams();
	}

	public List<Etudiant> listEtudiantsInTeam(Team team){
		return business.listEtudiantsInTeam(team);
	}


	public List<Project> projectsOfTeam(Team team){
		return business.listProjectsOfTeam(team);
	}





	public void updateTeamLeaderStatus(Etudiant e){
		int status = business.changeTeamLeaderStatus(e);
		FacesMessage msg; 
		if(status == 1) {
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", e + " statut de team leader changer!");   
		}else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");   
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}



	public void addTeam(ActionEvent event) {
		FacesMessage msg; 
		team.setMatiere((Matiere)event.getComponent().getAttributes().get("matiere"));
		int status = business.addTeam(team);
		if(status == 1) {
			init();
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", team.getName() + " added with success");   
		}else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");  
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}

	public void onRowEdit(RowEditEvent event) {
		Team t = (Team)event.getObject();
		FacesMessage msg; 
		int status = business.updateTeam(t) ;
		if(status == 1) {
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", t.getName() + " Updated with success");
		}else {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
		}

		FacesContext.getCurrentInstance().addMessage(null, msg); 

	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((Team) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}




	public void delete() {
		FacesMessage msg; 
		Team status =  business.deleteTeam(team);
		if(status !=null) {
			init();
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", team.getName() + " deleted with success");
		}else {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}


	public void setTeam(Team team) {
		this.team = team;
	}


	public Team getTeam() {
		return team;
	}


	public List<Team> getTeams() {
		return teams;
	}


	public List<Matiere> listMatieres(){
		return business.listeMatieres();
	}

	public Etudiant teamLeader(Team team) {
		return business.selectTeamLeaderOfTeam(team);
	}

	public List<Team> listTeamsInMatiere(Matiere m){
		return business.listTeamsInMatiere(m);
	}

}
