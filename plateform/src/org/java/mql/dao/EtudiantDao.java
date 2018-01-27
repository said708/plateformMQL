package org.java.mql.dao;

import java.util.List;

import org.java.mql.dao.mediator.DAOservice;
import org.java.mql.models.Etudiant;

public interface EtudiantDao extends DAOservice{
	int addEtudiant(Etudiant etudiant);
	Etudiant deleteEtudiant(Etudiant etudiant);
	List<Etudiant> selectAllEtudiant();
	Etudiant selectEtudiantById(long id);
	int updateEtudiant(Etudiant etudiant);
}
