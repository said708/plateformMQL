package org.java.mql.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.java.mql.dao.TeamDao;
import org.java.mql.dao.mediator.DaoMediatorService;
import org.java.mql.models.Etudiant;
import org.java.mql.models.Project;
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
	public Team deleteTeam(Team team) {
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
	public long updateTeam(Team team) {
		template.update(team);
		return team.getId();
	}

	@Override
	public List<Etudiant> selectEtudiantsInTeam(Team team) {
		String query="from Etudiant where team_id =? ";
		return (List<Etudiant>) template.find(query, team.getId());
		
	}

	@Override
	public int removeEtudiantFromTeam(Etudiant student, Team team) {
		String query="UPDATE Etudiant SET team_id = NULL  where ID = ? and team_id = ? " ;
		return template.bulkUpdate(query, new Object[]{student.getId(),team.getId()});
	}

	@Override
	public int addProjectToTeam(Project project, Team team) {
		String query="UPDATE Project SET TEAM = ? where ID = ?  " ;
		return template.bulkUpdate(query, new Object[]{team.getId(),project.getId()});
		
	}

	@Override
	public int removeProjectFromTeam(Project project, Team team) {
		String query="UPDATE Project SET TEAM = NULL  where id = ? and TEAM = ? " ;
		return template.bulkUpdate(query, new Object[]{project.getId(),team.getId()});
	}
	
	@Override
	public int addEtudiantToTeam(Etudiant etudiant, Team team) {
		String query="UPDATE Etudiant SET team_id = ?  where ID = ?  " ;
		return template.bulkUpdate(query, new Object[]{team.getId(),etudiant.getId()});
	}
	


	
	

}
