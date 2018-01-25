package org.java.mql.web.actions;

import org.java.mql.business.Module2Business;
import org.java.mql.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


@Component
@RequestScope
public class TeamAction {

	@Autowired
	private Module2Business business;

	@Autowired
	private Team team;



	public TeamAction() {
	}


	public void setBusiness(Module2Business business) {
		this.business = business;
	}

	public Module2Business getBusiness() {
		return business;
	}


	public void setTeam(Team team) {
		this.team = team;
	}



	public Team getTeam() {
		return team;
	}


}
