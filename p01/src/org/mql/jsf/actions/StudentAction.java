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
	
	
	
	
	public String addStudent() {
		return "studentAddedOk";
	}

}
