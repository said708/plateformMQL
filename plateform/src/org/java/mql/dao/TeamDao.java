package org.java.mql.dao;

import java.util.List;

import org.java.mql.dao.mediator.DAOservice;
import org.java.mql.models.Etudiant;
import org.java.mql.models.Team;

public interface TeamDao extends DAOservice{
	long addTeam(Team team);
	Team deleteTeam(long idTeam);
	List<Team> selectAllTeam();
	Team selectTeamById(long id);
	long updateTeam(long teamId , Team team);
	public List<Etudiant> selectEtudinatsInTeams(long teamId);
	int removeEtudiantFromTeam(long studentId, long team_id);
	public int addProjectToTeam(long projectId, long teamId);
	public int removeProjectFromTeam(long projectId, long teamId);
	int addEtudiantToTeam(long idEtudiant, long teamId);
}