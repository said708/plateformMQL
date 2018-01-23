package org.java.mql.dao;

import java.util.List;

import org.java.mql.dao.mediator.DAOservice;
import org.java.mql.models.Project;


public interface ProjectDao extends DAOservice{
	int addProjet(Project projet);
	Project deleteProjet(long idProjet);
	List<Project> selectAllProjet();
	Project selectProjetById(long id);
	int updateProjet(long idProjet , Project projet);
}
