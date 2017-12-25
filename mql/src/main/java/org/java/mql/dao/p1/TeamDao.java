package org.java.mql.dao.p1;

import java.util.List;

import org.java.mql.dao.DAOservice;
import org.java.mql.models.p01.Team;

public interface TeamDao extends DAOservice{
	int addTeam(Team team);
	Team deleteTeam(long idTeam);
	List<Team> selectAllTeam();
	Team selectTeamById(long id);
	int updateTeam(long teamId , Team team);
}
