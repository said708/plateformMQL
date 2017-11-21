package org.java.mql.dao.hibernate.p2;

import java.util.List;

import org.java.mql.dao.DaoMediatorService;
import org.java.mql.dao.p2.LiverableDao;
import org.java.mql.models.p02.Liverable;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class HDefaultLiverableDao  extends DaoMediatorService  implements LiverableDao {

	private HibernateTemplate template;
	

	public HDefaultLiverableDao(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public int addLiverable(Liverable liverable) {
		return 0;
	}

	@Override
	public Liverable deleteLiverable(long idLiverable) {
		return null;
	}

	@Override
	public List<Liverable> selectAllLiverable() {
		return null;
	}

	@Override
	public Liverable selectLiverableById(long id) {
		return null;
	}

	@Override
	public int updateLiverable(long idLiverable, Liverable liverable) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
