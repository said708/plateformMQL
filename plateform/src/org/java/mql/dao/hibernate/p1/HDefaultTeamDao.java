package org.java.mql.dao.hibernate.p1;

import java.util.List;

import org.java.mql.dao.DaoMediator;
import org.java.mql.dao.p1.TeamDao;
import org.java.mql.models.p01.Team;

public class HDefaultTeamDao implements TeamDao {

	@Override
	public void setMediator(DaoMediator daoMediator) {
		// TODO Auto-generated method stub

	}

	@Override
	public int addTeam(Team team) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Team deleteTeam(long idTeam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> selectAllTeam() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team selectTeamById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateTeam(long teamId, Team team) {
		// TODO Auto-generated method stub
		return 0;
	}

}
