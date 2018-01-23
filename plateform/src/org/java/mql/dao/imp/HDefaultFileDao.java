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
	public File deleteFile(long idFile) {
		try {
			File file = template.get(File.class, idFile);
			log.info("HDefaultFileDao.deleteFile(...) -> File was deleted successfully !");
			return file;
		} catch (Exception e) {
			//e.printStackTrace();
			log.error("HDefaultFileDao.deleteFile(...) -> Doesn't work as expected ! -> " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<File> selectAllFile() {
		try {
			List<File> list = template.loadAll(File.class);
			log.info("HDefaultFileDao.selectAllFile() -> Files(list) were retrieved successfully !");
			return list;
		} catch (Exception e) {
			log.error("HDefaultFileDao.selectAllFile() -> Doesn't work as expected ! -> " + e.getMessage());
			return null;	
		}
	}

	@Override
	public File selectFileById(long id) {
		try {
			File file = template.get(File.class, id);
			log.info("HDefaultFileDao.selectFileById() -> File was retrieved successfully !");
			return file;
		} catch (Exception e) {
			log.error("HDefaultFileDao.selectFileById() -> Doesn't work as expected ! -> " + e.getMessage());
			return null;	
		}
	}

	@Override
	public int updateFile(long idFile, File file) {
		try {
			template.update(file);
			log.info("HDefaultFileDao.updateFile() -> File was updated successfully !");
			return 1;
		} catch (Exception e) {
			log.error("HDefaultFileDao.updateFile() -> Doesn't work as expected ! -> " + e.getMessage());
			return 0;	
		}
	}

}
