package org.java.mql.dao.hibernate.p2;

import java.util.List;

import org.java.mql.dao.DaoMediator;
import org.java.mql.dao.p2.ProjectDao;
import org.java.mql.models.p02.Project;

public class HDefaultProjectDao implements ProjectDao {

	@Override
	public void setMediator(DaoMediator daoMediator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int addProjet(Project projet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Project deleteProjet(long idProjet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> selectAllProjet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project selectProjetById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProjet(long idProjet, Project projet) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
