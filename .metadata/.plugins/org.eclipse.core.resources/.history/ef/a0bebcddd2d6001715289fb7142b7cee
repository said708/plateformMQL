package org.java.mql.dao.hibernate.p1;

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
		return team.getId();
	}

	@Override
	public Team deleteTeam(long idTeam) {
		Team team = this.selectTeamById(idTeam);
		template.delete(team);
		 return team;
	}

	@Override
	public List<Team> selectAllTeam() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team selectTeamById(long id) {
		List<?> teams = template.find("FROM team WHERE id=?" , id);
		return null;
	}

	@Override
	public long updateTeam(long teamId, Team team) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
