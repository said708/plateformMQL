package org.java.mql.dao.hibernate.p1;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.java.mql.dao.DaoMediatorService;
import org.java.mql.dao.p1.EtudiantDao;
import org.java.mql.models.p01.Etudiant;
import org.springframework.stereotype.Repository;



@Repository("hibernateEt")
public class HDefaultEtudiantDao extends DaoMediatorService implements EtudiantDao {

	//private static Hashtable<Integer, Etudiant> list ;
	private static final Logger log = Logger.getLogger(HDefaultEtudiantDao.class);

	

	@Override
	public int addEtudiant(Etudiant etudiant) {
		persist(etudiant);
		return 1;
	}

	
	@Override
	public Etudiant deleteEtudiant(long id) {
		Query query = getSession().createSQLQuery("delete from Etudiant where id_Etud = :id");
		query.setLong("id", id);
		query.executeUpdate();
		return null;
		
	}

	
	@Override
	public List<Etudiant> selectAllEtudiant() {
		Criteria criteria = getSession().createCriteria(Etudiant.class);
		return (List<Etudiant>) criteria.list();
	}

	
	@Override
	public Etudiant selectEtudiantById(long id) {
		Criteria criteria = getSession().createCriteria(Etudiant.class);
		criteria.add(Restrictions.eq("id",id));
		return (Etudiant) criteria.uniqueResult();
	}

	

	

	@Override
	public int updateEtudiant(long idEtudiant, Etudiant etudiant) {
		// TODO Auto-generated method stub
		return 0;
	}

	


}
