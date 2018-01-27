package org.java.mql.web.actions;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.java.mql.business.Module2Business;
import org.java.mql.models.Matiere;
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
		teams = business.listTeams();

	}




	public void addTeam() {
		FacesMessage msg; 
		int status = business.addTeam(team);
		if(status == 1) {
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", team.getName() + " added with success");   
		}else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");   
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}

	
	public void onRowEdit(RowEditEvent event) {
		Team t = (Team)event.getObject();
		FacesMessage msg; 
		if(business.isAnTeamExiste(t)){
			int status = business.updateTeam(t) ;

			if(status == 1) {
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", t.getName() + " Updated with success");
			}else {
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
			}

		}else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Team Not exist !");   
		FacesContext.getCurrentInstance().addMessage(null, msg); 

	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((Team) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}




	public void delete(Team m) {
		FacesMessage msg; 
		if(business.isAnTeamExiste(m)){
			Team status =  business.deleteTeam(m);
			if(status !=null) {
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", m.getName() + " deleted with success");
			}else {
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
			}

		}else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Team not  exist |");   
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


}
