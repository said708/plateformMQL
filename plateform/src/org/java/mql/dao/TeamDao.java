package org.java.mql.dao;

import java.util.List;

import org.java.mql.dao.mediator.DAOservice;
import org.java.mql.models.Etudiant;
import org.java.mql.models.Project;
import org.java.mql.models.Team;

public interface TeamDao extends DAOservice{
	long addTeam(Team team);
	Team deleteTeam(Team team);
	List<Team> selectAllTeam();
	Team selectTeamById(long id);
	long updateTeam(Team team);
	public List<Etudiant> selectEtudiantsInTeam(Team team);
	int removeEtudiantFromTeam(Etudiant student, Team team);
	public int addProjectToTeam(Project project, Team team);
	public int removeProjectFromTeam(Project project, Team team);
	int addEtudiantToTeam(Etudiant etudiant, Team team);
}