package org.java.mql.dao;

import java.util.List;

import org.java.mql.dao.mediator.DAOservice;
import org.java.mql.models.Enseignant;

public interface EnseignantDao extends DAOservice{
	int addEnseignant(Enseignant Enseignant);
	Enseignant deleteEnseignant(long idEnseignant);
	List<Enseignant> selectAllEnseignant();
	Enseignant selectEnseignantById(long id);
	int updateEnseignant(long idEnseignant , Enseignant Enseignant);
}