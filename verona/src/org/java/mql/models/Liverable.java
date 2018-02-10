package org.java.mql.models;

public class Liverable  {
	private long id;
	private String name;
	private Project project;

	
	public Liverable() {
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
	
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	@Override
	public boolean equals(Object o) {
		if ((o == null) || !(o instanceof Liverable) || o == this) {
			return false;
		}
		Liverable other = (Liverable) o;
		return (other.getId() == this.id) ;
	}

	@Override
	public int hashCode() {
		return (int) (id * 31 + 990876);
	}
	
	public String toString() {
		return name;
	}

}
