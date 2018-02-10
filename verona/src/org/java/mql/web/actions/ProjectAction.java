package org.java.mql.web.actions;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.java.mql.business.Module2Business;
import org.java.mql.models.Matiere;
import org.java.mql.models.Project;
import org.java.mql.models.Team;
import org.java.mql.web.utils.HelpConvertor;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class ProjectAction {

	@Autowired
	private Module2Business service;

	@Autowired
	private Project project;


	private List<Project> projects;

	private Date date;

	@PostConstruct
	public void init() {
		projects = new Vector<>();
	}


	public List<Project> listProjects() {
		return service.listProjects();
	}


	public List<Matiere> listMatiers(){
		return service.listeMatieres();
	}



	public void newProject(ActionEvent event) {
		FacesMessage msg; 
		if(!service.isAnProjectExiste(project)){
			project.setDatePublication(this.getCurrentDate());
			project.setDeadLine(HelpConvertor.dateToString(date, "dd-MM-yyyy"));
			Matiere matiere = (Matiere)event.getComponent().getAttributes().get("matiere");
			project.setMatiere(matiere);
			int status = service.addProject(project) ;
			if(status == 1) {
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", project.getName() + " added with success");
			}else {
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
			}

		}else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Project already exist !");   
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}



	public void onRowEdit(RowEditEvent event) {
		Project p = (Project)event.getObject();
		System.out.println(date);
		FacesMessage msg; 
		if(service.isAnProjectExiste(p)){
			if(date!=null) {
				p.setDeadLine(HelpConvertor.dateToString(date, "dd-MM-yyyy"));
			}
			int status = service.updateProject(p) ;

			if(status == 1) {
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", p.getName() + " Updated with success");
			}else {
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
			}

		}else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Project not exists !");   
		FacesContext.getCurrentInstance().addMessage(null, msg); 

	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((Project) event.getObject()).getName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}


	public List<Project> projectsInTeam(Team team){
		return service.listProjectsOfTeam(team);
	}



	public void delete(Project p) {
		FacesMessage msg; 
		if(service.isAnProjectExiste(p)){
			Project status =  service.deleteProject(p);
			if(status !=null) {
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", p.getName() + " deleted with success");
			}else {
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
			}

		}else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Project not  exist !");   
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}


	public List<Project> listProjectsInMatiere(Matiere matiere){
		return service.listProjectsInMatiere(matiere);
	}

	public void addProjectToMatiere(ActionEvent event) {
		Matiere matiere = (Matiere)event.getComponent().getAttributes().get("matiere");
		for (Project project : projects) {
			project.setMatiere(matiere);
			service.updateProject(project);
		}

	}
	
	
	
	

	public String getCurrentDate() {
		Date date = new Date();
		return HelpConvertor.dateToString(date, "dd-MM-yyyy");
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Project getProject() {
		return project;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}	

}
