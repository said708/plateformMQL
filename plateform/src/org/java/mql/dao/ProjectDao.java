package org.java.mql.dao;

import java.util.List;

import org.java.mql.dao.mediator.DAOservice;
import org.java.mql.models.Project;


public interface ProjectDao extends DAOservice{
	int addProjet(Project projet);
	Project deleteProjet(Project project);
	List<Project> selectAllProjet();
	Project selectProjetById(long id);
	int updateProjet(Project projet);
}
