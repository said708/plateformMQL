package org.java.mql.dao.p2;

import java.util.List;

import org.java.mql.dao.DAOservice;
import org.java.mql.models.p2.File;


public interface FileDao extends DAOservice{
	int addFile(File file);
	File deleteFile(long idFile);
	List<File> selectAllFile();
	File selectFileById(long id);// Modified by YcDev, previous signature : List<File> selectFileById(long id); 
	int updateFile(long idFile , File file);
}
