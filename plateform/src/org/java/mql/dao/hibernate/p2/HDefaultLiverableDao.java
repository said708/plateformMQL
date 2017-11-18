package org.java.mql.dao.hibernate.p2;

import java.util.List;

import org.java.mql.dao.DaoMediator;
import org.java.mql.dao.p2.LiverableDao;
import org.java.mql.models.p02.Liverable;

public class HDefaultLiverableDao implements LiverableDao {

	@Override
	public void setMediator(DaoMediator daoMediator) {
		// TODO Auto-generated method stub

	}

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
	public List<Liverable> selectLiverableById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateLiverable(long idLiverable, Liverable liverable) {
		// TODO Auto-generated method stub
		return 0;
	}

}
