package org.java.mql.dao.imp;

import java.util.List;

import org.java.mql.dao.TeamDao;
import org.java.mql.dao.mediator.DaoMediatorService;
import org.java.mql.models.Team;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class HDefaultTeamDao  extends DaoMediatorService  implements TeamDao {

	private HibernateTemplate template;
	
	
	public HDefaultTeamDao(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public int addTeam(Team team) {
		template.save(team);
		return 1;
	}

	@Override
	public Team deleteTeam(Team team) {
		template.delete(team);
		return team;
	}

	@Override
	public List<Team> selectAllTeam() {
	    return template.loadAll(Team.class);  
	}

	@Override
	public Team selectTeamById(long id) {
		Team t=(Team)template.get(Team.class,id);  
	    return t; 
	 
	}

	@Override
	public int updateTeam(Team team) {
		template.update(team);
		return 1;
	}

}
