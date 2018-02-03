package org.java.mql.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.java.mql.dao.EtudiantDao;
import org.java.mql.dao.mediator.DaoMediatorService;
import org.java.mql.models.Etudiant;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class HDefaultEtudiantDao   extends DaoMediatorService  implements EtudiantDao {

	private HibernateTemplate template;


	public HDefaultEtudiantDao(HibernateTemplate template) {
		this.template = template;
	}
	
	@Override
	public int addEtudiant(Etudiant etudiant) {
		template.save(etudiant);
		return 1;
	}

	@Override
	public Etudiant deleteEtudiant(Etudiant etudiant) {
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
	public int updateEtudiant(Etudiant etudiant) {
		template.update(etudiant);
		return 1;
	}



}
