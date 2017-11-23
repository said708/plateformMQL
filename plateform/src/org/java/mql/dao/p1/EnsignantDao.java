package org.java.mql.dao.p1;

import java.util.List;

import org.java.mql.dao.DAOservice;
import org.java.mql.models.p1.Ensignant;

public interface EnsignantDao extends DAOservice{
	int addEnsignant(Ensignant ensignant);
	Ensignant deleteEnsignant(long idEnsignant);
	List<Ensignant> selectAllEnsignant();
	Ensignant selectEnsignantById(long id);
	int updateEnsignant(long idEnsignant , Ensignant ensignant);
}
