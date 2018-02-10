package org.java.mql.dao;

import java.util.List;

import org.java.mql.dao.mediator.DAOservice;
import org.java.mql.models.Project;


public interface ProjectDao extends DAOservice{
	int addProjet(Project projet);
	Project deleteProjet(Project project);
	List<Project> selectAllProjet();
	Project selectProjetById(long id);
	List<Project> selectAllProjectByMatiere(String matiereName);// YcDev
	int updateProjet(Project projet);
}
