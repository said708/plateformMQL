package org.java.mql.models;

import java.util.List;

public class Matiere  {
	private long id;
	private String name;
	private Enseignant enseignant;
	private List<Project> projects;
	private List<Team> teams;	
	
	public Matiere() {
	}

	public Matiere(long id, String name) {
		enseignant = new Enseignant();
		this.id = id;
		this.name = name;
	}


	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
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


	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	@Override
	public boolean equals(Object o) {
		if ((o == null) || (o.getClass() != Matiere.class)) {
			return false;
		}
		Matiere other = (Matiere) o;
		return (other.id == this.id) ;
	}

	@Override
	public int hashCode() {
		return (int) (id * 31 + 990876);
	}

	@Override
	public String toString() {
		return name;
	}



}
