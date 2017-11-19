package org.java.mql.dao.p2;

import java.util.List;

import org.java.mql.dao.DaoMediatorService;
import org.java.mql.models.p02.Liverable;
import org.springframework.stereotype.Repository;


@Repository("defaultLi")
public class DefaultLiverableDao extends DaoMediatorService implements LiverableDao {

	@Override
	public int addLiverable(Liverable liverable) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Liverable deleteLiverable(long idLiverable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Liverable> selectAllLiverable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Liverable selectLiverableById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateLiverable(long idLiverable, Liverable liverable) {
		// TODO Auto-generated method stub
		return 0;
	}

}
