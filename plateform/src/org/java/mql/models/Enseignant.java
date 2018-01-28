package org.java.mql.models;

public class Enseignant  {
	
	
	private long id;
	private String nom;
	private String prenom;
	private String phone;
	private String email;


	public Enseignant() {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if ((o == null) || !(o instanceof Enseignant) || o == this) {
			return false;
		}
		Enseignant other = (Enseignant) o;
		return (other.id == this.id) ;
	}

	@Override
	public int hashCode() {
		return (int) (id * 31 + 990876);
	}

	@Override
	public String toString() {
		return nom+" "+prenom;
	}


}
