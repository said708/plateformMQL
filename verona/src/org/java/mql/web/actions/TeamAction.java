package org.java.mql.web.actions;

import java.util.List;
import java.util.Vector;

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
import org.springframework.web.context.annotation.RequestScope;


@Component
@RequestScope
public class TeamAction {

	@Autowired
	private Module2Business business;

	@Autowired
	private Team team;

	private List<Team> teams;

	@PostConstruct
	public void init() {
		teams = new Vector<>();
		System.out.println(business.listEtudiantNotAffectedToAnyTeam());
	}

	public List<Etudiant> listEtudiantsInTeam(Team team){
		return business.listEtudiantsInTeam(team);
	}

	public List<Team> listTeams(){
		return business.listTeams();
	}


	public List<Project> projectsOfTeam(Team team){
		return business.listProjectsOfTeam(team);
	}


	public void addProjectToTeam(ActionEvent event) {
		Project project = (Project)event.getComponent().getAttributes().get("project");
		Team team = (Team)event.getComponent().getAttributes().get("team");
		System.out.println(project);
		System.out.println(team);
		business.addProjectToTeam(project, team);
	}
	
	
	public void updateTeamLeaderStatus(Etudiant e){
		team.setTeamLeader(e);
		int updateTeam = business.updateTeam(team);
		FacesMessage msg; 
		if(updateTeam == 1) {
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", e + " statut de team leader changer!");   
		}else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");   
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}



	public void addTeams(ActionEvent event) {
		Matiere matiere = (Matiere)event.getComponent().getAttributes().get("matiere");
		for (Team team : teams) {
			business.addTeamToMatiere(team, matiere);
		}
	}


	public void addTeam(ActionEvent event) {
		Matiere matiere = (Matiere)event.getComponent().getAttributes().get("matiere");
		int status = business.addTeamToMatiere(team, matiere);
		FacesMessage msg; 
		if(status == 1) {
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", team + " added with success!");   
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

	
	
	
	public void deleteTeamFromMatiere(ActionEvent event) {
		FacesMessage msg; 
		Matiere matiere = (Matiere)event.getComponent().getAttributes().get("matiere");
		Team team = (Team)event.getComponent().getAttributes().get("team");
		int status = business.removeTeamFromMatiere(team, matiere);
		if(status !=-1) {
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", team.getName() + " deleted with success");
		}else {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}



	public void delete(ActionEvent event) {
		FacesMessage msg; 
		Team team = (Team)event.getComponent().getAttributes().get("team");
		Team status =  business.deleteTeam(team);
		if(status !=null) {
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


	public void setTeams(List<Team> teams) {
		this.teams = teams;
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
