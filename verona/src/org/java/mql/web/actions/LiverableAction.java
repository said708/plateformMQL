package org.java.mql.web.actions;

import java.io.File;
import java.util.List;
import java.util.Vector;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.java.mql.business.Module2Business;
import org.java.mql.models.Liverable;
import org.java.mql.models.Matiere;
import org.java.mql.models.Project;
import org.java.mql.models.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


@Component
@RequestScope
public class LiverableAction {

	@Autowired
	private Module2Business business;

	@Autowired
	private Liverable liverable;

	private List<Matiere> matieres;
	private List<Project> projects;
	List<Liverable> liverables;
	private String matiere;
	private String project;
	private static final String liverablePath = "/home/yassine/Documents/MQL_liverables/";

	
	
	public static String getLiverablepath() {
		return liverablePath;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	@PostConstruct
	public void init() {
		matieres = business.listeMatieres();
		projects = new Vector<>();
		liverables = new Vector<>();
		//initializing projects with default values
		//projects = business.selectAllProjectByMatiere(matieres.get(2).getName());
		//getLiverables();
	}

	public LiverableAction() {
	}

	public void setBusiness(Module2Business business) {
		this.business = business;
	}

	public Module2Business getBusiness() {
		return business;
	}

	public void setLiverable(Liverable liverable) {
		this.liverable = liverable;
	}

	public Liverable getLiverable() {
		return liverable;
	}

	public void onMatiereChange(String matiereName) {
		projects = business.selectAllProjectByMatiere(matiereName);
	}

	public List<Project> getProjects() {
		return projects;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public List<Liverable> getLiverables() {
		return liverables;
	}

	public void displayMessage() {
		FacesMessage msg;
		msg = new FacesMessage("liverable : " + liverable.getName());


		FacesContext.getCurrentInstance().addMessage(null, msg);  
	}


	public Liverable deleteLiverable() {
		return null;
	}

	public void addLiverable() {
		FacesMessage msg; 
		if(!business.isAnLiverableExiste(liverable)){
			int status =  business.addLiverable(liverable) ;
			if(status == 1) {
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", liverable.getName() + " added with success");
			}else {
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");
			}

		}else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "Enseignant already exist |");   
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

}
