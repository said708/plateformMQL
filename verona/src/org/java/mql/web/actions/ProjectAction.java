package org.java.mql.web.actions;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.java.mql.business.Module2Business;
import org.java.mql.models.Matiere;
import org.java.mql.models.Project;
import org.java.mql.models.Team;
import org.java.mql.models.Type;
import org.java.mql.web.utils.HelpConvertor;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class ProjectAction {

	@Autowired
	private Module2Business service;

	@Autowired
	private Project project;

	private List<Project> projects;

	private Date date;
	
	private String prefixPath;

	@PostConstruct
	public void init() {
		projects = service.listProjects();
		prefixPath = LiverableAction.getLiverablepath();
		
	}
	
	public List<Matiere> listMatiers(){
		return service.listeMatieres();
	}

	public void newProject() {
		FacesMessage msg; 
		if(!service.isAnProjectExiste(project)){
			project.setDatePublication(this.getCurrentDate());
			project.setDeadLine(HelpConvertor.dateToString(date, "dd-MM-yyyy"));
			System.out.println(project);
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

	public void delete(Project p) {
		FacesMessage msg; 
		System.out.println(p);
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

	public void createProjectDirectory(Project project) {
		String matiereName = project.getMatiere().getName();
		String projectName = project.getName();
		String teamName = "equipe_A";
		String projectPath;// = prefixPath + matiereName + "/" + projectName + "/" + teamName; 
		
		projectPath = prefixPath + matiereName;
		createDir(projectPath);// matiere directory
		
		projectPath += "/" + projectName;
		createDir(projectPath);// project directory
		
		projectPath += "/" + teamName;
		createDir(projectPath);// team directory
		
		
		Type[] types = Type.values();
		for (int i=0;i<types.length;i++) {// types of directory
			String tmpPath =  projectPath + "/" + types[i];
			createDir(tmpPath);
		}
	}
	
	public void createDir(String path) {
		File directory = new File(path);
		try {
			directory.mkdir();
			System.out.println("Directory was created successfully !");
			
		} catch (Exception e) {
			System.out.println("Error : Directory has not been created ");
			e.printStackTrace();
		}
	}


}
