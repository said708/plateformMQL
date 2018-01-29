package org.java.mql.models;

public class Matiere  {
	private long id;
	private String name;
	private Enseignant enseignant;
	
	public Matiere() {
	}

	public Matiere(long id, String name) {
		enseignant = new Enseignant();
		this.id = id;
		this.name = name;
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
		if ((o == null) || !(o instanceof Matiere) || o == this) {
			return false;
		}
		Matiere other = (Matiere) o;
		return (other.getId() == this.id) ;
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
