package org.java.mql.dao.p1;

import java.util.List;

import org.java.mql.dao.DAOservice;
import org.java.mql.models.p1.Etudiant;

public interface EtudiantDao extends DAOservice{
	long addEtudiant(Etudiant etudiant);
	Etudiant deleteEtudiant(long id);
	List<Etudiant> selectAllEtudiant();
	Etudiant selectEtudiantById(long id);
	long updateEtudiant(long idEtudiant, Etudiant etudiant);
}