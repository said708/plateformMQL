package org.java.mql.dao.hibernate.p1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.java.mql.dao.DaoMediatorService;
import org.java.mql.dao.p1.EtudiantDao;
import org.java.mql.models.p1.Etudiant;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class HDefaultEtudiantDao   extends DaoMediatorService  implements EtudiantDao {

	private HibernateTemplate template;


	public HDefaultEtudiantDao(HibernateTemplate template) {
		this.template = template;
	}
	
	@Override
	public long addEtudiant(Etudiant etudiant) {
		template.save(etudiant);
		return 1;
	}

	@Override
	public Etudiant deleteEtudiant(long id) {
		Etudiant etudiant =   template.get(Etudiant.class, id); 
		template.delete(etudiant);
		return etudiant;
	}

	@Override
	public List<Etudiant> selectAllEtudiant() {
		List<Etudiant> list=new ArrayList<Etudiant>();  
	    list=template.loadAll(Etudiant.class);  
	    return list;  
	}

	@Override
	public Etudiant selectEtudiantById(long id) {
		Etudiant e=(Etudiant)template.get(Etudiant.class,id);  
		    return e;   
	}

	@Override
	public long updateEtudiant(long idEtudiant, Etudiant etudiant) {
		template.update(etudiant);
		return 1;
	}

	

}
