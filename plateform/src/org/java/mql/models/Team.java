package org.java.mql.models;

public class Team {

	private long id;
	private String name;
	private Matiere matiere;

	public Team() {
	}



	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
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
	public String toString() {
		return name;
	}




}
