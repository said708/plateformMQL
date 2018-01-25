package org.java.mql.web.actions;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.java.mql.business.Module2Business;
import org.java.mql.models.Matiere;
import org.java.mql.models.Project;
import org.java.mql.web.utils.HelpConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


@Component
@RequestScope
public class ProjectAction {

	@Autowired
	private Module2Business business;

	@Autowired
	private Project project;

	
	private Date date;


	public ProjectAction() {
	}


	public void setBusiness(Module2Business business) {
		this.business = business;
	}

	public Module2Business getBusiness() {
		return business;
	}
	
	
	public List<Matiere> listMatiers(){
		return business.listeMatieres();
	}



	public void newProject() {
		FacesMessage msg; 
		if(!business.isAnProjectExiste(project)){
			project.setDatePublication(this.getCurrentDate());
			project.setDeadLine(HelpConvertor.dateToString(date, "dd-MM-yyyy"));
			 int status = business.addProject(project) ;
			 if(status == 1) {
				 msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", project.getName() + " added with success");
			 }else {
				 msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
			 }
			   
		}else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Project already exist |");   
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Project getProject() {
		return project;
	}
	
	public List<Project> listProjects(){
		return business.listProjects();
	}
	
	public void delete() {
		FacesMessage msg; 
		if(business.isAnProjectExiste(project)){
			 Project status =  business.deleteProject(project);
			 if(status !=null) {
				 msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", project.getName() + " deleted with success");
			 }else {
				 msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
			 }
			   
		}else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Project not  exist |");   
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}
	
	
	public String getCurrentDate() {
		Date date = new Date();
		return HelpConvertor.dateToString(date, "dd-MM-yyyy");
	}
	
	public Date getDate() {
		return date;
	}
	
	
	public void setDate(Date date) {
		this.date = date;
	}
	

}
