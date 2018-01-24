package org.java.mql.web.actions;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.java.mql.business.DefaultModule2Business;
import org.java.mql.business.Module2Business;
import org.java.mql.models.Enseignant;
import org.java.mql.models.Matiere;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


@Component
@SessionScope
public class EnseignantAction {

	private Enseignant enseignant;
	private Module2Business business;

	public EnseignantAction() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationConext.xml");
		business = context.getBean(DefaultModule2Business.class);
		context.close();
	}




	public void addEnsignant() {
		FacesMessage msg;  
		int status = business.addEnseignant(enseignant);
		if(status == 1)
			msg = new FacesMessage("Selected", enseignant.getNom() + " added with success");  
		else  
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "try to fill all the fields correctly");   
		FacesContext.getCurrentInstance().addMessage(null, msg); 
	}
	
	public List<Matiere> listMatiers(){
		return business.listeMatieres();
	}

}
