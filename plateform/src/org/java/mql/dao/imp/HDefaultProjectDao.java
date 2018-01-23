package org.java.mql.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.java.mql.dao.ProjectDao;
import org.java.mql.dao.mediator.DaoMediatorService;
import org.java.mql.models.Project;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class HDefaultProjectDao extends DaoMediatorService implements ProjectDao {

	private HibernateTemplate template;
	
	
	public HDefaultProjectDao(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public int addProjet(Project projet) {
		template.save(projet);
		return 1;
	}

	@Override
	public Project deleteProjet(long idProjet) {
		Project project =   template.get(Project.class, idProjet); 
		template.delete(project);
		return project;
	}

	@Override
	public List<Project> selectAllProjet() {
		List<Project> list=new ArrayList<Project>();  
	    list=template.loadAll(Project.class);  
	    return list;  
	}

	@Override
	public Project selectProjetById(long id) {
		Project projet=(Project)template.get(Project.class,id);
		return projet;
	}

	@Override
	public int updateProjet(long idProjet, Project projet) {
		template.update(projet);
		return 1;
	}

	
}
