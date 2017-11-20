package org.java.mql.dao.p1;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.java.mql.dao.DaoMediatorService;
import org.java.mql.models.p01.Etudiant;
import org.java.mql.models.p01.Team;
import org.java.mql.models.p02.Project;


public class DefaultTeamDao extends DaoMediatorService implements TeamDao{
	
	private static final Logger log = Logger.getLogger(DefaultTeamDao.class);
	private static  Hashtable<Long, Team> list ;
	
	static {
		list = new Hashtable<Long, Team>();
		Vector<Etudiant> data = new Vector<Etudiant>();
		Vector<Project> projects = new Vector<Project>();
		
		
		data.add(new Etudiant(1, "lachgar", "driss","lachgar.990pp@gmail.com", "09887676554"));
		data.add(new Etudiant(2, "imane", "hajar","hajar.0900@gmail.com", "0967564390"));
		projects.add(new Project(1, "spring", "spring is a jee freamwork", "01/01/2017", "01/03/2018"));
		list.put((long) 1, new Team(1, "groupeA", data , projects));
//		data.clear();
//		projects.clear();
		
		
		data.add(new Etudiant(1, "ahmed", "tajir","tajir.990pp@gmail.com", "09887676554"));
		data.add(new Etudiant(2, "kamal", "brahmi","brahmi.0900@gmail.com", "0967564390"));
		projects.add(new Project(1, "spring", "spring is a jee freamwork", "01/01/2017", "01/03/2018"));
		list.put((long) 2, new Team(2, "groupeB", data , projects));
//		data.clear();
//		projects.clear();
		
		
		data.add(new Etudiant(1, "imane", "slawi","slawi.990pp@gmail.com", "09887676554"));
		data.add(new Etudiant(2, "yassine", "ghalim","ghalim.0900@gmail.com", "0967564390"));
		projects.add(new Project(1, "spring", "spring is a jee freamwork", "01/01/2017", "01/03/2018"));
		list.put((long) 3, new Team(3, "groupeC", data , projects));
//		data.clear();
//		projects.clear();
		
		
		data.add(new Etudiant(1, "yassine", "alloul","alloul.990pp@gmail.com", "09887676554"));
		data.add(new Etudiant(2, "ismail", "brahmi","brahmi.0900@gmail.com", "0967564390"));
		projects.add(new Project(1, "spring", "spring is a jee freamwork", "01/01/2017", "01/03/2018"));
		list.put((long) 4, new Team(4, "groupeD", data , projects));
	}
	@Override
	public int addTeam(Team team) {
		try {
			if(!list.containsKey(team.getId())) {
				list.put(team.getId(), team);
				return 1;
			}else {
				throw new Exception("Team "+team.getId()+" already exist");
			}
		} catch (Exception e) {
			log.error("error in team addTeam Caused bey : "+e.getMessage());
			return -1;
		}
	}

	@Override
	public Team deleteTeam(long idTeam) {
		try {
			Team  e = list.get(idTeam);
			list.remove(idTeam);
			return e;
		}catch(Exception e) {
			log.error("Team with key "+idTeam+" not found !");
			return null;
		}
	}

	@Override
	public List<Team> selectAllTeam() {
		try {
			return new Vector<Team>(list.values());
		} catch (Exception e) {
			log.error("list of teams is empty");
			return null;
		}
		
	}

	@Override
	public Team selectTeamById(long id) {
		try {
			return list.get(id);
		} catch (Exception e) {
			log.error("list dosen't have a team with id "+id);
			return null;
		}
		
	}

	@Override
	public int updateTeam(long idTeam, Team team) {
		try {
			list.remove(idTeam);
			list.put(idTeam, team);
			return (int) idTeam;
		}catch(Exception e) {
			log.error("team with key "+idTeam+" not found !");
			return -1;
		}
	}

}
