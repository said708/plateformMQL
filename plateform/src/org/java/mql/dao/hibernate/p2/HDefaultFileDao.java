package org.java.mql.dao.hibernate.p2;

import java.util.List;

import org.java.mql.dao.DaoMediator;
import org.java.mql.dao.p2.FileDao;
import org.java.mql.models.p02.File;

public class HDefaultFileDao implements FileDao {

	@Override
	public void setMediator(DaoMediator daoMediator) {
		// TODO Auto-generated method stub
		
	}

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
