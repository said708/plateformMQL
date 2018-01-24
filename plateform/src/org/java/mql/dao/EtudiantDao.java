package org.java.mql.dao;

import java.util.List;

import org.java.mql.dao.mediator.DAOservice;
import org.java.mql.models.Etudiant;

public interface EtudiantDao extends DAOservice{
	long addEtudiant(Etudiant etudiant);
	Etudiant deleteEtudiant(long id);
	List<Etudiant> selectAllEtudiant();
	Etudiant selectEtudiantById(long id);
	long updateEtudiant(long idEtudiant, Etudiant etudiant);
}