package org.java.mql.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.java.mql.dao.TeamDao;
import org.java.mql.dao.mediator.DaoMediatorService;
import org.java.mql.models.Etudiant;
import org.java.mql.models.Team;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class HDefaultTeamDao  extends DaoMediatorService  implements TeamDao {

	private HibernateTemplate template;
	
	
	public HDefaultTeamDao(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public long addTeam(Team team) {
		template.save(team);
		return 1;
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

	@Override
	public List<Etudiant> selectEtudinatsInTeams(long teamId) {
		String query="from Etudiant where team_id =? ";
		return (List<Etudiant>) template.find(query, teamId);
		
	}

	@Override
	public int removeEtudiantFromTeam(long studentId, long team_id) {
		String query="UPDATE Etudiant SET team_id = NULL  where ID = ? and team_id = ? " ;
		return template.bulkUpdate(query, new Object[]{studentId,team_id});
	}

	@Override
	public int addProjectToTeam(long projectId, long teamId) {
		String query="UPDATE Project SET TEAM = ? where ID = ?  " ;
		return template.bulkUpdate(query, new Object[]{teamId,projectId});
		
	}

	@Override
	public int removeProjectFromTeam(long projectId, long teamId) {
		String query="UPDATE Project SET TEAM = NULL  where id = ? and TEAM = ? " ;
		return template.bulkUpdate(query, new Object[]{projectId,teamId});
	}
	
	@Override
	public int addEtudiantToTeam(long idEtudiant, long teamId) {
		String query="UPDATE Etudiant SET team_id = ?  where ID = ?  " ;
		return template.bulkUpdate(query, new Object[]{teamId,idEtudiant});
	}
	


	
	

}