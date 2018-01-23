package org.java.mql.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.java.mql.dao.EnseignantDao;
import org.java.mql.dao.mediator.DaoMediatorService;
import org.java.mql.models.Enseignant;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class HDefaultEnseignantDao   extends DaoMediatorService  implements EnseignantDao {

	private HibernateTemplate template;
	
	
	public HDefaultEnseignantDao(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public int addEnseignant(Enseignant Enseignant) {
		template.save(Enseignant);
		return 1;
	}

	@Override
	public Enseignant deleteEnseignant(long idEnseigant) {
		Enseignant enseignant =   template.get(Enseignant.class, idEnseigant); 
		template.delete(enseignant);
		return enseignant;
	}

	@Override
	public List<Enseignant> selectAllEnseignant() {
		List<Enseignant> list=new ArrayList<Enseignant>();  
	    list=template.loadAll(Enseignant.class);  
	    return list; 
	}

	@Override
	public Enseignant selectEnseignantById(long idEnseigant) {
		Enseignant e=(Enseignant)template.get(Enseignant.class,idEnseigant);
		return e;
	}

	@Override
	public int updateEnseignant(long idEnseignant, Enseignant Enseignant) {
		template.update(Enseignant);
		return 1;
	}


}
