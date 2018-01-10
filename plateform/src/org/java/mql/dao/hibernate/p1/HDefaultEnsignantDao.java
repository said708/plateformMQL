package org.java.mql.dao.hibernate.p1;

import java.util.List;
import java.util.Vector;

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
	public int addEnsignant(Ensignant ensignant) {
		if(ensignant != null) {
			template.save(ensignant);	
			return 1;
		}
		return -1;
		
		
	}

	@Override
	public Ensignant deleteEnsignant(long idEnseigant) {
		Ensignant enseignant =   this.selectEnsignantById(idEnseigant);
		template.delete(enseignant);
		return enseignant;
	}

	@Override
	public List<Ensignant> selectAllEnsignant() {
		List<Ensignant> list=new Vector<Ensignant>();  
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
		if(idEnsignant > -1 ) {
			template.update(ensignant);
		}
		return 1;
	}


}
