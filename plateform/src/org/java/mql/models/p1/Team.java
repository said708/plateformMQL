package org.java.mql.models.p1;

import java.util.List;

import org.java.mql.models.p2.Matiere;
import org.java.mql.models.p2.Project;

import java.util.Vector;



public class Team {


	private long id;
	private String name;
	private List<Etudiant> etudiants;
	private List<Project> projects;
	private Matiere matiere;

	public Team() {
	}

	public Team(String name) {
		
		this.name = name;
		projects = new Vector<Project>();
		etudiants = new Vector<Etudiant>();
	    matiere = new Matiere();

		
	}
	
	public Team(long id,String name) {
		
		this.id=id;
		this.name = name;
		projects = new Vector<Project>();
		etudiants = new Vector<Etudiant>();
	    matiere = new Matiere();

		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Matiere getMatiere() {
	return matiere;
	}
	public void setMatiere(Matiere matiere) {
	this.matiere = matiere;
	}

	public List<Etudiant> getEtudiants() {
	return etudiants;
	}



	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}



	public List<Project> getProjects() {
		return projects;
	}



	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name +  "]";
	}




}
