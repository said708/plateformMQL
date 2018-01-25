package org.java.mql.web.actions;

import org.java.mql.business.Module2Business;
import org.java.mql.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


@Component
@RequestScope
public class ProjectAction {

	@Autowired
	private Module2Business business;

	@Autowired
	private Project project;



	public ProjectAction() {
	}


	public void setBusiness(Module2Business business) {
		this.business = business;
	}

	public Module2Business getBusiness() {
		return business;
	}




	public void setProject(Project project) {
		this.project = project;
	}

	public Project getProject() {
		return project;
	}

}
