package org.java.mql.models.p2;

import java.util.List;

public class Liverable  {
	private long id;
	private String name;
	private List<AbstractFile> files;
	
	public Liverable() {
	}
	
	
	public List<AbstractFile> getFiles() {
		return files;
	}


	public void setFiles(List<AbstractFile> files) {
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
