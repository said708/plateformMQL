package org.java.mql.dao.hibernate.p2;

import java.util.List;

import org.java.mql.dao.DaoMediatorService;
import org.java.mql.dao.p2.ProjectDao;
import org.java.mql.models.p02.Project;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class HDefaultProjectDao extends DaoMediatorService implements ProjectDao {

	private HibernateTemplate template;
	
	
	public HDefaultProjectDao(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public int addProjet(Project projet) {
		return 0;
	}

	@Override
	public Project deleteProjet(long idProjet) {
		return null;
	}

	@Override
	public List<Project> selectAllProjet() {
		return null;
	}

	@Override
	public Project selectProjetById(long id) {
		return null;
	}

	@Override
	public int updateProjet(long idProjet, Project projet) {
		return 0;
	}

	
}
