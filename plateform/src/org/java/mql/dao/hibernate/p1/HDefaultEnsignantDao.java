package org.java.mql.dao.hibernate.p1;

import java.util.List;

import org.java.mql.dao.DaoMediator;
import org.java.mql.dao.p1.EnsignantDao;
import org.java.mql.models.p01.Ensignant;

public class HDefaultEnsignantDao implements EnsignantDao {

	@Override
	public void setMediator(DaoMediator daoMediator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int addEnsignant(Ensignant ensignant) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Ensignant deleteEnsignant(long idEnsignant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ensignant> selectAllEnsignant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ensignant selectEnsignantById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateEnsignant(long idEnsignant, Ensignant ensignant) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
