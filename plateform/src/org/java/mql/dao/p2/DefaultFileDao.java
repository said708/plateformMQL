package org.java.mql.dao.p2;

import java.util.List;

import org.java.mql.dao.DaoMediatorService;
import org.java.mql.models.p2.File;



public class DefaultFileDao extends DaoMediatorService implements FileDao {

	
	
	
	@Override
	public int addFile(File file) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public File deleteFile(long idFile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<File> selectAllFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<File> selectFileById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateFile(long idFile, File file) {
		// TODO Auto-generated method stub
		return 0;
	}

}
