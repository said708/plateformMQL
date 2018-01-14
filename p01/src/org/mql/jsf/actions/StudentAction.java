package org.mql.jsf.actions;

import org.mql.jsf.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class StudentAction {

	@Autowired
	private Student student;
	
	public StudentAction() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Student getStudent() {
		return student;
	}
	
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	public String addStudent() {
		return "studentAddedOk";
	}

}
