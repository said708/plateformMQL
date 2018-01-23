package org.java.mql.models;

public abstract class AbstractFile {

	private long id;
	private String name;
	private String path;
	private Liverable liverable;


	public AbstractFile() {
	}

	public AbstractFile(long id, String name, String path) {
		liverable = new Liverable();
		this.id = id;
		this.name = name;
		this.path = path;
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}


	public Liverable getLiverable() {
		return liverable;
	}
	public void setLiverable(Liverable liverable) {
		this.liverable = liverable;
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
