package org.java.mql.dao.hibernate.p1;

import java.util.ArrayList;
import java.util.List;

import org.java.mql.dao.DaoMediatorService;
import org.java.mql.dao.p1.TeamDao;
import org.java.mql.models.p1.Team;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class HDefaultTeamDao  extends DaoMediatorService  implements TeamDao {

	private HibernateTemplate template;
	
	
	public HDefaultTeamDao(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public long addTeam(Team team) {
		template.save(team);
		return 0;
	}

	@Override
	public Team deleteTeam(long id) {
		Team team =   template.get(Team.class, id); 
		template.delete(team);
		return team;
	}

	@Override
	public List<Team> selectAllTeam() {
		List<Team> list=new ArrayList<Team>();  
	    list=template.loadAll(Team.class);  
	    return list;  
	}

	@Override
	public Team selectTeamById(long id) {
		Team t=(Team)template.get(Team.class,id);  
	    return t; 
	 
	}

	@Override
	public long updateTeam(long teamId, Team team) {
		template.update(team);
		return teamId;
	}

	

}
