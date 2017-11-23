package org.java.mql.dao.hibernate.p2;

import java.util.List;

import org.java.mql.dao.DaoMediatorService;
import org.java.mql.dao.p2.MatiereDao;
import org.java.mql.models.p2.Matiere;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class HDefaultMatiereDao  extends DaoMediatorService  implements MatiereDao {

	private HibernateTemplate template;
	
	
	
	public HDefaultMatiereDao(HibernateTemplate template) {
		this.template = template;
	}

	

	@Override
	public int addMatiere(Matiere matiere) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Matiere deleteMatiere(long idMatiere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Matiere> selectAllMatiere() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Matiere> selectMatiereById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMatiere(long idMatiere, Matiere matiere) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
