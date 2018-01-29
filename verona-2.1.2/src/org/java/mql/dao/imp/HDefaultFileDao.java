package org.java.mql.dao.imp;

import java.util.List;

import org.apache.log4j.Logger;
import org.java.mql.dao.FileDao;
import org.java.mql.dao.mediator.DaoMediatorService;
import org.java.mql.models.File;
import org.springframework.orm.hibernate5.HibernateTemplate;

// Modified by YcDev
public class HDefaultFileDao  extends DaoMediatorService  implements FileDao {

	private HibernateTemplate template;
	private static final Logger log = Logger.getLogger(HDefaultFileDao.class);

	public HDefaultFileDao(HibernateTemplate template) {
		super();
		this.template = template;
	}

	@Override
	public int addFile(File file) {
		try {
			template.save(file);
			log.info("HDefaultFileDao.addFile(...) -> File was added successfully !");
			return 1;
		} catch (Exception e) {
			//e.printStackTrace();
			log.error("HDefaultFileDao.addFile(...) -> Doesn't work as expected ! -> " + e.getMessage());
			return 0;
		}
	}

	@Override
	public File deleteFile(File file) {
		template.delete(file);
		log.info("HDefaultFileDao.deleteFile(...) -> File was deleted successfully !");
		return file;
	}

	@Override
	public List<File> selectAllFile() {
		List<File> list = template.loadAll(File.class);
		return list;
	}

	@Override
	public File selectFileById(long id) {
		File file = template.get(File.class, id);
		return file;
	}

	@Override
	public int updateFile(File file) {
		template.update(file);
		return 1;
	}

}
