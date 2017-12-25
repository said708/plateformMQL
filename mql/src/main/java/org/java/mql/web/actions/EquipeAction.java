package org.java.mql.web.actions;

import java.util.HashSet;
import java.util.List;
import java.util.Vector;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.java.mql.business.DefaultModule2Business;
import org.java.mql.business.Module2Business;
import org.java.mql.models.p01.Etudiant;
import org.java.mql.models.p01.Team;
import org.java.mql.models.p02.Project;

@ManagedBean
@SessionScoped
public class EquipeAction {

	private Module2Business service = new DefaultModule2Business();
	private List<Etudiant> etudiants = new Vector<>();
	private List<Etudiant> membres = new Vector<Etudiant>();
	private List<Project> projets = new Vector<Project>();
	private long selected, selected1;
	private String nom;
	private int id;

	public EquipeAction() {

	}

	public String ajouterEquipe() {

	//	Team t = new Team(id, nom, etudiants, projets);// Team(code,
														// membres.get(0));
	//	t.addMembre(new HashSet<>(membres));

	//	service.addTeam(t);
		return "";
	}

	public String add() {

		Etudiant s = get(selected, etudiants);
		membres.add(s);

		etudiants.remove(s);

		return "";
	}

	public String delete() {
		Etudiant s = get(selected1, membres);
		membres.remove(s);

		etudiants.add(s);

		return "";
	}

	private Etudiant get(long cne, List<Etudiant> list) {
		for (Etudiant e : list) {
			if (e.getId() == cne)
				return e;
		}
		return null;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
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
