package org.java.mql.dao.p2;

import java.util.List;

import org.java.mql.dao.DAOservice;
import org.java.mql.models.p02.Liverable;


public interface LiverableDao extends DAOservice{
	int addLiverable(Liverable liverable);
	Liverable deleteLiverable(long idLiverable);
	List<Liverable> selectAllLiverable();
	Liverable selectLiverableById(long id);
	int updateLiverable(long idLiverable , Liverable liverable);
}
