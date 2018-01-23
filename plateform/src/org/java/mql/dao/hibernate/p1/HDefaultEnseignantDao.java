package org.java.mql.dao.hibernate.p1;

import java.util.ArrayList;
import java.util.List;

import org.java.mql.dao.DaoMediatorService;
import org.java.mql.dao.p1.EnseignantDao;
import org.java.mql.models.p1.Enseignant;
import org.java.mql.models.p1.Etudiant;
import org.java.mql.models.p1.Team;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class HDefaultEnseignantDao   extends DaoMediatorService  implements EnseignantDao {

	private HibernateTemplate template;
	
	
	public HDefaultEnseignantDao(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public int addEnsignant(Enseignant ensignant) {
		template.save(ensignant);
		return 1;
	}

	@Override
	public Enseignant deleteEnsignant(long idEnseigant) {
		Enseignant enseignant =   template.get(Enseignant.class, idEnseigant); 
		template.delete(enseignant);
		return enseignant;
	}

	@Override
	public List<Enseignant> selectAllEnsignant() {
		List<Enseignant> list=new ArrayList<Enseignant>();  
	    list=template.loadAll(Enseignant.class);  
	    return list; 
	}

	@Override
	public Enseignant selectEnsignantById(long idEnseigant) {
		Enseignant e=(Enseignant)template.get(Enseignant.class,idEnseigant);
		return e;
	}

	@Override
	public int updateEnsignant(long idEnsignant, Enseignant ensignant) {
		template.update(ensignant);
		return 1;
	}


}
