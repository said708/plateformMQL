package org.java.mql.models.p02;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.java.mql.models.p01.Team;

@Entity
@Table(name="PROJET")

public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "nom", nullable = false)
	private String name;
	@Column(name = "description", nullable = false)
	private String desc;
	@Column(name = "DatePublication", nullable = false)
	private String datePublication;
	@Column(name = "Deadline", nullable = false)
	private String deadLine;

	@ManyToOne
	@JoinColumn(name="id_group", nullable=false)
	private Team team;

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
