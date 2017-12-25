package org.java.mql.dao.hibernate.p1;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.java.mql.dao.DaoMediatorService;
import org.java.mql.dao.p1.TeamDao;
import org.java.mql.models.p01.Team;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



@Repository("hibernateTe")
public class HDefaultTeamDao extends DaoMediatorService implements TeamDao {

	//private static Hashtable<Integer, Etudiant> list ;
	private static final Logger log = Logger.getLogger(HDefaultEtudiantDao.class);

	
	
	@Override
	public int addTeam(Team team) {
		persist(team);
		return 1;
	}

	@Override
	public Team deleteTeam(long idTeam) {
		Query query = getSession().createSQLQuery("delete from groupe where id_group = :idTeam");
		query.setLong("idTeam", idTeam);
		query.executeUpdate();
		return null;
	}

	@Override
	public List<Team> selectAllTeam() {
		Criteria criteria = getSession().createCriteria(Team.class);
		return (List<Team>) criteria.list();
	}

	@Override
	public Team selectTeamById(long idTeam) {
		Criteria criteria = getSession().createCriteria(Team.class);
		criteria.add(Restrictions.eq("idTeam",idTeam));
		return (Team) criteria.uniqueResult();
	}

	@Override
	public int updateTeam(long teamId, Team team) {
		// TODO Auto-generated method stub
		return 0;
	}


	


}
