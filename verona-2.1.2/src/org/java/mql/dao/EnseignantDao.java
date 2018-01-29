package org.java.mql.dao;

import java.util.List;

import org.java.mql.dao.mediator.DAOservice;
import org.java.mql.models.Enseignant;

public interface EnseignantDao extends DAOservice{
	int addEnseignant(Enseignant Enseignant);
	Enseignant deleteEnseignant(Enseignant enseignant);
	List<Enseignant> selectAllEnseignant();
	Enseignant selectEnseignantById(long enseignantId);
	int updateEnseignant(Enseignant enseignant);
}