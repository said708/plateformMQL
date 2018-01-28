package org.java.mql.models;

public class Project {

	private long id;
	private String name;
	private String description;
	private String datePublication;
	private String deadLine;
	private Matiere matiere;
	private Liverable liverable;
	private Team team;




	public Project() {
	}

	
	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
	
	public Liverable getLiverable() {
		return liverable;
	}

	public void setLiverable(Liverable liverable) {
		this.liverable = liverable;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDatePublication() {
		return datePublication;
	}
	public void setDatePublication(String datePublication) {
		this.datePublication = datePublication;
	}
	public String getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}
	@Override
	public boolean equals(Object o) {
		if ((o == null) || !(o instanceof Project) || o == this) {
			return false;
		}
		Project other = (Project) o;
		return (other.getId() == this.id) ;
	}

	@Override
	public int hashCode() {
		return (int) (id * 31 + 990876);
	}

	@Override
	public String toString() {
		return name ;
	}



}
