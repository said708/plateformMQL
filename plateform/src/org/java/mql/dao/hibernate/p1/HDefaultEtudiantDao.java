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
<<<<<<< HEAD
		if(etudiant != null) {
			template.save(etudiant);
			return 1;
		}
		return -1;
=======
		template.save(etudiant);
		return 1;
>>>>>>> c527fb3c6a4287c7479cbc9b2eb88ea442954363
	}

	@Override
	public Etudiant deleteEtudiant(long id) {
		Etudiant etudiant =   this.selectEtudiantById(id);
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
		Etudiant e = template.get(Etudiant.class,id);  
		return e;   
	}

	@Override
	public long updateEtudiant(long idEtudiant, Etudiant etudiant) {
		template.update(etudiant);
		return 1;
	}



}
