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

	public Project(long id, String name, String desc, String datePublication, String deadLine) {
		matiere = new Matiere();
		liverable = new Liverable();
		team = new Team();
		this.id = id;
		this.name = name;
		this.description = desc;
		this.datePublication = datePublication;
		this.deadLine = deadLine;
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
		if ((o == null) || (o.getClass() != Project.class)) {
			return false;
		}
		Project other = (Project) o;
		return (other.id == this.id) ;
	}

	@Override
	public int hashCode() {
		return (int) (id * 31 + 990876);
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", datePublication="
				+ datePublication + ", deadLine=" + deadLine + ", matiere=" + matiere + ", liverable=" + liverable
				+ ", team=" + team + "]";
	}
	
	
	
}
