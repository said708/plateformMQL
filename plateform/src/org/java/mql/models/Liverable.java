package org.java.mql.models;

import java.util.List;
import java.util.Vector;

public class Liverable  {
	private long id;
	private String name;
	private List<File> files;
	private Project project;

	public Liverable() {
	}


	public Liverable(long id, String name) {
		files = new Vector<File>();
		project = new Project();
		this.id = id;
		this.name = name;
	}


	public List<File> getFiles() {
		return files;
	}


	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}


	public void setFiles(List<File> files) {
		this.files = files;
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
	public boolean equals(Object o) {
		if ((o == null) || (o.getClass() != Liverable.class)) {
			return false;
		}
		Liverable other = (Liverable) o;
		return (other.id == this.id) ;
	}

	@Override
	public int hashCode() {
		return (int) (id * 31 + 990876);
	}

}
