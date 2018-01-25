package org.java.mql.web.actions;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.java.mql.business.Module2Business;
import org.java.mql.models.Matiere;
import org.java.mql.models.Project;
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
			 int status =  business.addProject(project) ;
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

}
