package org.java.mql.dao.p1;

import java.util.List;

import org.java.mql.dao.DAOservice;
import org.java.mql.models.p1.Enseignant;

public interface EnseignantDao extends DAOservice{
	int addEnsignant(Enseignant ensignant);
	Enseignant deleteEnsignant(long idEnsignant);
	List<Enseignant> selectAllEnsignant();
	Enseignant selectEnsignantById(long id);
	int updateEnsignant(long idEnsignant , Enseignant ensignant);
}