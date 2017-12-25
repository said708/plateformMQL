package org.java.mql.dao.p1;

import java.util.List;

import org.java.mql.dao.DAOservice;
import org.java.mql.models.p1.Etudiant;
import org.java.mql.models.p1.Team;
import org.java.mql.models.p2.Project;

public interface TeamDao extends DAOservice{
	int addTeam(Team team);
	Team deleteTeam(long idTeam);
	List<Team> selectAllTeam();
	Team selectTeamById(long id);
	int updateTeam(long teamId , Team team);
	List<Etudiant> selectEtudinatsInTeams(long idTeam );
	int removeEtudiantFromTeam(long studentId, long team_id );
	int addProjectToTeam(long projectId , long teamId);
	int removeProjectFromTeam(long projectId , long teamId);
	int addEtudiantToTeam(long etudiant , long teamId);
}
=======
package org.java.mql.dao.p1;

import java.util.List;

import org.java.mql.dao.DAOservice;
import org.java.mql.models.p1.Team;

public interface TeamDao extends DAOservice{
	long addTeam(Team team);
	Team deleteTeam(long idTeam);
	List<Team> selectAllTeam();
	Team selectTeamById(long id);
	long updateTeam(long teamId , Team team);
}
