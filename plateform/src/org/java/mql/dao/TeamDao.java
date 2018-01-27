package org.java.mql.dao;

import java.util.List;

import org.java.mql.dao.mediator.DAOservice;
import org.java.mql.models.Team;

public interface TeamDao extends DAOservice{
	int addTeam(Team team);
	Team deleteTeam(Team team);
	List<Team> selectAllTeam();
	Team selectTeamById(long id);
	int updateTeam(Team team);
}