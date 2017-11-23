package org.java.mql.dao.p1;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.java.mql.dao.DaoMediatorService;
import org.java.mql.models.p1.Ensignant;


public class DefaultEnsignantDao extends DaoMediatorService implements EnsignantDao {

	private static Hashtable<Long, Ensignant> list ;
	private static final Logger log = Logger.getLogger(DefaultEnsignantDao.class);

	static {
		list = new Hashtable<Long, Ensignant>();
		list.put((long) 1, new Ensignant(1, "Thitah", "", "0613206969"));
		list.put((long) 2, new Ensignant(2, "mensour", "riyad", "09887676554"));
		list.put((long) 3, new Ensignant(3, "chaoui", "yassine", "0878675434"));
		list.put((long) 4, new Ensignant(4, "fourkane", "hasnae", "0789231109"));

	}

	@Override
	public int addEnsignant(Ensignant ensignant) {
		try {
			list.put(ensignant.getId(), ensignant);
			return 1;
		} catch (Exception e) {
			log.error("ensignant must be not null");
			return -1;
		}
	}

	public Ensignant deleteEnsignant(long idEnsignant) {
		try {
			return list.remove(idEnsignant);
		}catch(Exception e) {
			log.error("Ensignant with key "+idEnsignant+" not found !");
			return null;
		}
	}

	public List<Ensignant> selectAllEnsignant() {
		return new Vector<Ensignant>(list.values());
	}

	public Ensignant selectEnsignantById(long id) {
		return list.get(id);
	}

	public int updateEnsignant(long idEnsignant, Ensignant ensignant) {
		list.remove(idEnsignant);
		list.put( idEnsignant, ensignant);
		return (int) idEnsignant;
	}

}
