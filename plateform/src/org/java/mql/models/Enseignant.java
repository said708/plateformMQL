package org.java.mql.models;

import java.util.List;
import java.util.Vector;

public class Enseignant  {
	private long id;
	private String nom;
	private String prenom;
	private String phone;
	private List<Matiere> matieres;

	public Enseignant() {
	}
	
	public Enseignant(long id, String nom, String prenom, String phone) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.phone = phone;
		matieres = new Vector<Matiere>();
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}



	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
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

	
	@Override
	public boolean equals(Object o) {
	  if ((o == null) || (o.getClass() != Enseignant.class)) {
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
		return "Ensignant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", phone=" + phone + "]";
	}



}