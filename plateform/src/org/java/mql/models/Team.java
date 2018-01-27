package org.java.mql.models;

import java.util.List;



public class Team {


	private long id;
	private String name;
	private List<Project> projects;
	private List<Etudiant> etudiants;
	private Etudiant teamLeader;

	public Team() {
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



	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}


	public List<Project> getProjects() {
		return projects;
	}

	public Etudiant getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(Etudiant teamLeader) {
		this.teamLeader = teamLeader;
	}



	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return name;
	}




}
