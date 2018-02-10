package org.java.mql.models;

import java.util.List;

public class Team {

	private long id;
	private String name;
	private List<Etudiant> etudiants;
	private Etudiant teamLeader;

	public Team() {
	}



	public Etudiant getTeamLeader() {
		return teamLeader;
	}


	public void setTeamLeader(Etudiant teamLeader) {
		this.teamLeader = teamLeader;
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

	@Override
	public boolean equals(Object o) {

		if ((o == null) || !(o instanceof Team) || o == this) {
			return false;
		}
		Team other = (Team) o;
		return  (other.getId() == this.id);
	}

	@Override
	public int hashCode() {
		return (int) (id * 31 + 990876);
	}



	@Override
	public String toString() {
		return name;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}



	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}




}
