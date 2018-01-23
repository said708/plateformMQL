package org.java.mql.dao;

import java.util.List;

import org.java.mql.dao.mediator.DAOservice;
import org.java.mql.models.Matiere;


public interface MatiereDao extends DAOservice{
	int addMatiere(Matiere matiere);
	Matiere deleteMatiere(long idMatiere);
	List<Matiere> selectAllMatiere();
	Matiere selectMatierById(long id);
	int updateMatiere(long idMatiere , Matiere matiere);
}
