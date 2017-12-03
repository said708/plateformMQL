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
