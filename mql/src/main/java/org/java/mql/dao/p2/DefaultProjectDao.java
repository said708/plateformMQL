package org.java.mql.dao.p2;

import java.util.List;

import org.java.mql.dao.DaoMediatorService;
import org.java.mql.models.p02.Project;
import org.springframework.stereotype.Repository;


@Repository("defaultPr")
public class DefaultProjectDao extends DaoMediatorService implements ProjectDao {

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
