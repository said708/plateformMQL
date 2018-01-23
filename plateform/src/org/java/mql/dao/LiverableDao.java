package org.java.mql.dao;

import java.util.List;

import org.java.mql.dao.mediator.DAOservice;
import org.java.mql.models.Liverable;


public interface LiverableDao extends DAOservice{
	int addLiverable(Liverable liverable);
	Liverable deleteLiverable(long idLiverable);
	List<Liverable> selectAllLiverable();
	Liverable selectLiverableById(long id);
	int updateLiverable(long idLiverable , Liverable liverable);
}
