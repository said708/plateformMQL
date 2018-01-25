package org.java.mql.models;

public class File{
	
	private long id;
	private String name;
	private String path;
	private String uploadDate;
	private long size;
	private Liverable liverable;


	public File() {
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




	public Liverable getLiverable() {
		return liverable;
	}




	public void setLiverable(Liverable liverable) {
		this.liverable = liverable;
	}

	

	@Override
	public boolean equals(Object o) {
		if ((o == null) || (o.getClass() != File.class)) {
			return false;
		}
		File other = (File) o;
		return (other.id == this.id) ;
	}


	@Override
	public int hashCode() {
		return (int) (id * 31 + 990876);
	}
}
