package org.java.mql.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.java.mql.dao.MatiereDao;
import org.java.mql.dao.mediator.DaoMediatorService;
import org.java.mql.models.Matiere;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class HDefaultMatiereDao  extends DaoMediatorService  implements MatiereDao {

	private HibernateTemplate template;
	
	
	
	public HDefaultMatiereDao(HibernateTemplate template) {
		this.template = template;
	}

	

	@Override
	public int addMatiere(Matiere matiere) {
		template.save(matiere);
		return 1;
	}

	@Override
	public Matiere deleteMatiere(long idMatiere) {
		Matiere matiere =   template.get(Matiere.class, idMatiere); 
		template.delete(matiere);
		return matiere;
	}

	@Override
	public List<Matiere> selectAllMatiere() {
		List<Matiere> list=new ArrayList<Matiere>();  
	    list=template.loadAll(Matiere.class);  
	    return list;  
	}

	@Override
	public Matiere selectMatierById(long id) {
		Matiere matiere=(Matiere)template.get(Matiere.class,id);
		return matiere;
	}

	@Override
	public int updateMatiere(long idMatiere, Matiere matiere) {
		template.update(matiere);
		return 1;
	}


}
