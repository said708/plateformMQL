package org.java.mql.models.p01;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.java.mql.models.p02.Project;


@Entity
@Table(name="GROUPE")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "NOM", nullable = false)
	private String nom;
	@OneToMany(mappedBy="team")
	private List<Etudiant> etudiants;
	@OneToMany(mappedBy="team")
	private List<Project> projects;
	public Team() {
	}

	public Team(long id, String nom, List<Etudiant> etudiants, List<Project> projects) {
		super();
		this.id = id;
		this.nom = nom;
		this.etudiants = etudiants;
		this.projects = projects;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> Teams) {
		this.etudiants = Teams;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", nom=" + nom + ", etudiants=" + etudiants + "]";
	}

}
