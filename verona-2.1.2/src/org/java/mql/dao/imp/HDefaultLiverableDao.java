package org.java.mql.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.java.mql.dao.LiverableDao;
import org.java.mql.dao.mediator.DaoMediatorService;
import org.java.mql.models.Liverable;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class HDefaultLiverableDao  extends DaoMediatorService  implements LiverableDao {

	private HibernateTemplate template;


	public HDefaultLiverableDao(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public int addLiverable(Liverable livrable) {
		template.save(livrable);
		return 1;
	}

	@Override
	public Liverable deleteLiverable(Liverable livrable) {
		template.delete(livrable);
		return livrable;
	}

	@Override
	public List<Liverable> selectAllLiverable() {
		List<Liverable> list=new ArrayList<Liverable>();  
		list=template.loadAll(Liverable.class);  
		return list;
	}

	@Override
	public Liverable selectLiverableById(long id) {
		Liverable livrable=(Liverable)template.get(Liverable.class,id);
		return livrable;
	}

	@Override
	public int updateLiverable(Liverable liverable) {
		//template.update(liverable);// Commented by YcDev
		template.merge(liverable);// Using merge instead of update let us overcome the problem caused by update() method : by YcDev
		return 1;
	}



}
