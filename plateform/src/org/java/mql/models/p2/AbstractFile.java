package org.java.mql.models.p2;

public abstract class AbstractFile {
	
	private long id;
	private String name;
	private String path;


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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	abstract void add(AbstractFile  file);	

	@Override
	public boolean equals(Object o) {
	  if ((o == null) || (o.getClass() != AbstractFile.class)) {
	    return false;
	  }
	  AbstractFile other = (AbstractFile) o;
	  return (other.id == this.id) ;
	}

	@Override
	public int hashCode() {
	  return (int) (id * 31 + 990876);
	}
}
