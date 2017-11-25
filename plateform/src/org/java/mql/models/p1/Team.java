package org.java.mql.models.p1;

import java.util.List;
import java.util.Vector;

import org.java.mql.models.p2.Matiere;
import org.java.mql.models.p2.Project;

public class Team {
	
	private long id;
	private String name;
	private List<Etudiant> etudiants;
	private List<Project> projects;
	private Matiere matiere;

	
	public Team() {
		projects = new Vector<Project>();
		etudiants = new Vector<Etudiant>();
		matiere = new Matiere();
	}
	
	
	
	public Team(long id, String name) {
		this();
		this.id = id;
		this.name = name;
	}



	public long getId() {
		return id;
	}



	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
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



	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	@Override
	public boolean equals(Object o) {
	  if ((o == null) || (o.getClass() != Team.class)) {
	    return false;
	  }
	  Team other = (Team) o;
	  return (other.id == this.id) ;
	}

	@Override
	public int hashCode() {
	  return (int) (id * 31 + 990876);
	}


	@Override
	public String toString() {
		return "Team [id=" + id + ", nom=" + name + ", etudiants=" + etudiants + "]";
	}

}
