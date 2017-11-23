package org.java.mql.models.p2;

public class Project {
	private long id;
	private String name;
	private String desc;
	private String datePublication;
	private String deadLine;
	//private Liverable liverable;
	
	
	public Project() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Project(long id, String name, String desc, String datePublication, String deadLine) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.datePublication = datePublication;
		this.deadLine = deadLine;
	//	this.liverable = liverable;
	}



//	public Liverable getLiverable() {
//		return liverable;
//	}
//	public void setLiverable(Liverable liverable) {
//		this.liverable = liverable;
//	}
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
}
