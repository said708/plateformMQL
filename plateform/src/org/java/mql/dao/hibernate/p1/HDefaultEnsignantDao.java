package org.java.mql.dao.hibernate.p1;

import java.util.ArrayList;
import java.util.List;

import org.java.mql.dao.DaoMediatorService;
import org.java.mql.dao.p1.EnsignantDao;
import org.java.mql.models.p1.Ensignant;
import org.java.mql.models.p1.Etudiant;
import org.java.mql.models.p1.Team;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class HDefaultEnsignantDao   extends DaoMediatorService  implements EnsignantDao {

	private HibernateTemplate template;
	
	
	public HDefaultEnsignantDao(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public int addEnsignant(Ensignant ensignant) {
		template.save(ensignant);
		return 1;
	}

	@Override
	public Ensignant deleteEnsignant(long idEnseigant) {
		Ensignant enseignant =   template.get(Ensignant.class, idEnseigant); 
		template.delete(enseignant);
		return enseignant;
	}

	@Override
	public List<Ensignant> selectAllEnsignant() {
		List<Ensignant> list=new ArrayList<Ensignant>();  
	    list=template.loadAll(Ensignant.class);  
	    return list; 
	}

	@Override
	public Ensignant selectEnsignantById(long idEnseigant) {
		Ensignant e=(Ensignant)template.get(Ensignant.class,idEnseigant);
		return e;
	}

	@Override
	public int updateEnsignant(long idEnsignant, Ensignant ensignant) {
		template.update(ensignant);
		return 1;
	}


}
=======
package org.java.mql.dao.hibernate.p1;

import java.util.List;

import org.java.mql.dao.DaoMediatorService;
import org.java.mql.dao.p1.EnsignantDao;
import org.java.mql.models.p1.Ensignant;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class HDefaultEnsignantDao   extends DaoMediatorService  implements EnsignantDao {

	private HibernateTemplate template;
	
	
	public HDefaultEnsignantDao(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public long addEnsignant(Ensignant ensignant) {
		template.save(ensignant);
		return 0;
	}

	@Override
	public Ensignant deleteEnsignant(long idEnsignant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ensignant> selectAllEnsignant() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ensignant selectEnsignantById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long updateEnsignant(long idEnsignant, Ensignant ensignant) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
