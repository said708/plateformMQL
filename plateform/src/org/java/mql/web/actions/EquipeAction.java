package org.java.mql.web.actions;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.java.mql.business.DefaultModule2Business;
import org.java.mql.business.Module2Business;
import org.java.mql.models.p01.Etudiant;
import org.java.mql.models.p01.Team;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ManagedBean
@SessionScoped
public class EquipeAction {

	private Module2Business service ;
	private List<Etudiant>  etudiants;
	private List<Etudiant> membres ;
	private long selected, selected1;
	private String nom;
	

	public EquipeAction() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationConext.xml");
		service = context.getBean(DefaultModule2Business.class);
	}

	public String ajouterEquipe() {

		
		Team t = new Team();
		t.setNom(nom);
		t.setEtudiants(etudiants);
//		service.addListEtudiantsToTeam(membres, id);
		service.addTeam(t);
		return "";
	}

	public String add() {
		Etudiant s = get(selected, service.listEtudiants());

	
		membres.add(s);

		service.listEtudiants().remove(s);

		return "";
	}

	public String delete() {
		Etudiant s = get(selected1, membres);
		membres.remove(s);

		service.listEtudiants().add(s);

		return "";
	}

	private Etudiant get(long cne, List<Etudiant> list) {
		for (Etudiant e : list) {
			if (e.getId() == cne)
				return e;
		}
		return null;
	}


	

	public List<Etudiant> getMembres() {
		return membres;
	}

	public void setMembres(List<Etudiant> membres) {
		this.membres = membres;
	}

	public long getSelected() {
		return selected;
	}

	public void setSelected(long selected) {
		this.selected = selected;
	}

	public long getSelected1() {
		return selected1;
	}

	public void setSelected1(long selected1) {
		this.selected1 = selected1;
	}

	public String getCode() {
		return nom;
	}

	public void setCode(String nom) {
		this.nom = nom;
	}
}
