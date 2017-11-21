package org.java.mql.dao.hibernate.p1;

import java.util.List;

import org.java.mql.dao.DaoMediator;
import org.java.mql.dao.p1.EtudiantDao;
import org.java.mql.models.p01.Etudiant;

public class HDefaultEtudiantDao implements EtudiantDao {

	@Override
	public void setMediator(DaoMediator daoMediator) {
		
	}

	@Override
	public int addEtudiant(Etudiant etudiant) {
		return 0;
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
	public int updateEtudiant(long idEtudiant, Etudiant etudiant) {
		return 0;
	}

	

}
