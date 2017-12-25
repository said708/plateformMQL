package org.java.mql.dao.p2;

import java.util.List;

import org.java.mql.dao.DAOservice;
import org.java.mql.models.p02.Project;


public interface ProjectDao extends DAOservice{
	int addProjet(Project projet);
	Project deleteProjet(long idProjet);
	List<Project> selectAllProjet();
	Project selectProjetById(long id);
	int updateProjet(long idProjet , Project projet);
}
