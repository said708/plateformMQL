package org.java.mql.dao.hibernate.p2;

import java.util.ArrayList;
import java.util.List;

import org.java.mql.dao.DaoMediatorService;
import org.java.mql.dao.p2.LiverableDao;
import org.java.mql.models.p1.Etudiant;
import org.java.mql.models.p2.Liverable;
import org.java.mql.models.p2.Matiere;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class HDefaultLiverableDao  extends DaoMediatorService  implements LiverableDao {

	private HibernateTemplate template;
	

	public HDefaultLiverableDao(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public int addLiverable(Liverable livrable) {
		template.save(livrable);
		return 0;
	}

	@Override
	public Liverable deleteLiverable(long idLivrable) {
		Liverable livrable =   template.get(Liverable.class, idLivrable); 
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
	public int updateLiverable(long idLiverable, Liverable liverable) {
		template.update(liverable);
		return 1;
	}

	

}
