<<<<<<< HEAD
package org.java.mql.dao.p1;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.java.mql.dao.DaoMediatorService;
import org.java.mql.models.p1.Etudiant;


public class DefaultEtudiantDao extends DaoMediatorService implements EtudiantDao {

	private static Hashtable<Long, Etudiant> list ;
	private static final Logger log = Logger.getLogger(DefaultEtudiantDao.class);

	static {
		list = new Hashtable<Long, Etudiant>();
		list.put((long) 1, new Etudiant(1, "lachgar", "driss","lachgar.990pp@gmail.com", "09887676554"));
		list.put((long) 2, new Etudiant(2, "imane", "hajar","hajar.0900@gmail.com", "0967564390"));
		list.put((long) 3, new Etudiant(3, "omari", "saleh","omari.fashion@gmail.com", "0127898765"));
		list.put((long) 4, new Etudiant(4, "ahlal", "yassine","ahlal.ma3andouchklma@gmail.com", "0967665434"));
		list.put((long) 5, new Etudiant(5, "farouk", "omar","omar.234@gmail.com", "0999098767"));
	}

	@Override
	public long addEtudiant(Etudiant etudiant) {
		try {
			list.put(etudiant.getId(), etudiant);
			return 1;
		} catch (Exception e) {
			log.error("etudiant must be not null");
			return -1;
		}
	}

	
	@Override
	public Etudiant deleteEtudiant(long idEtudiant) {
		try {
			return list.remove(idEtudiant);
		}catch(Exception e) {
			log.error("etudiant with key "+idEtudiant+" not found !");
			return null;
		}
	}

	
	@Override
	public List<Etudiant> selectAllEtudiant() {
		return new Vector<Etudiant>(list.values());
	}

	
	@Override
	public Etudiant selectEtudiantById(long id) {
		return list.get(id);
	}

	
	
	@Override
	public long updateEtudiant(long idEtudiant, Etudiant etudiant) {
		try {
			list.remove(idEtudiant);
			list.put(idEtudiant, etudiant);
			return (int) idEtudiant;
		}catch(Exception e) {
			log.error("etudiant with key "+idEtudiant+" not found !");
			return -1;
		}
		
	}

}
=======
package org.java.mql.dao.p1;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.java.mql.dao.DaoMediatorService;
import org.java.mql.models.p1.Etudiant;


public class DefaultEtudiantDao extends DaoMediatorService implements EtudiantDao {

	private static Hashtable<Long, Etudiant> list ;
	private static final Logger log = Logger.getLogger(DefaultEtudiantDao.class);

	static {
		list = new Hashtable<Long, Etudiant>();
		list.put((long) 1, new Etudiant(1, "lachgar", "driss","lachgar.990pp@gmail.com", "09887676554"));
		list.put((long) 2, new Etudiant(2, "imane", "hajar","hajar.0900@gmail.com", "0967564390"));
		list.put((long) 3, new Etudiant(3, "omari", "saleh","omari.fashion@gmail.com", "0127898765"));
		list.put((long) 4, new Etudiant(4, "ahlal", "yassine","ahlal.ma3andouchklma@gmail.com", "0967665434"));
		list.put((long) 5, new Etudiant(5, "farouk", "omar","omar.234@gmail.com", "0999098767"));
	}

	@Override
	public int addEtudiant(Etudiant etudiant) {
		try {
			list.put(etudiant.getId(), etudiant);
			return 1;
		} catch (Exception e) {
			log.error("etudiant must be not null");
			return -1;
		}
	}

	
	@Override
	public Etudiant deleteEtudiant(long idEtudiant) {
		try {
			return list.remove(idEtudiant);
		}catch(Exception e) {
			log.error("etudiant with key "+idEtudiant+" not found !");
			return null;
		}
	}

	
	@Override
	public List<Etudiant> selectAllEtudiant() {
		return new Vector<Etudiant>(list.values());
	}

	
	@Override
	public Etudiant selectEtudiantById(long id) {
		return list.get(id);
	}

	
	
	@Override
	public int updateEtudiant(long idEtudiant, Etudiant etudiant) {
		try {
			list.remove(idEtudiant);
			list.put(idEtudiant, etudiant);
			return (int) idEtudiant;
		}catch(Exception e) {
			log.error("etudiant with key "+idEtudiant+" not found !");
			return -1;
		}
		
	}

}
>>>>>>> df471ea163a1e579bf6b7b523b05fc4f95f66f52
