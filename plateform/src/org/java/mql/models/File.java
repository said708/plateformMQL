package org.java.mql.models;

public class File{

	private long id;
	private String name;
	private String path;
	private String uploadDate;
	private long size;
	private Type type;
	private Liverable liverable;


	public File() {
	}


	public Liverable getLiverable() {
		return liverable;
	}

	public void setLiverable(Liverable liverable) {
		this.liverable = liverable;
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




	public String getUploadDate() {
		return uploadDate;
	}




	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}




	public long getSize() {
		return size;
	}




	public void setSize(long size) {
		this.size = size;
	}




	@Override
	public boolean equals(Object o) {
		if ((o == null) || !(o instanceof File) || o == this) {
			return false;
		}
		File other = (File) o;
		return (other.id == this.id) ;
	}


	@Override
	public int hashCode() {
		return (int) (id * 31 + 990876);
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
