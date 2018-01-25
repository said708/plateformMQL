package org.java.mql.models;

public class Etudiant {
	
	
	private long id;
	private String nom;
	private String prenom;
	private String email;
	private String phone;
	private Team team;
	
	


	public Etudiant() {
	}

	public Etudiant(long id, String nom, String prenom, String email, String phone) {
		team = new Team();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.phone = phone;
	}





	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Team getTeam() {
		return team;
	}



	public void setTeam(Team team) {
		this.team = team;
	}

	
	
	@Override
	public boolean equals(Object o) {
	  if ((o == null) || (o.getClass() != Etudiant.class)) {
	    return false;
	  }
	  Etudiant other = (Etudiant) o;
	  return (other.id == this.id) ;
	}

	@Override
	public int hashCode() {
	  return (int) (id * 31 + 990876);
	}


	@Override
	public String toString() {
		return nom + " " + prenom;
	}



	
	
	
	
}
