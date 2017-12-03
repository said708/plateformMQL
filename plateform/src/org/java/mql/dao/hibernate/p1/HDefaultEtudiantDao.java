package org.java.mql.dao.hibernate.p1;

import java.util.List;

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
		return etudiant.getId();
	}

	@Override
	public Etudiant deleteEtudiant(long id) {
		return null;
	}

	@Override
	public List<Etudiant> selectAllEtudiant() {
		return null;
	}

	@Override
	public Etudiant selectEtudiantById(long id) {
		return null;
	}

	@Override
	public long updateEtudiant(long idEtudiant, Etudiant etudiant) {
		return 0;
	}

	

}
