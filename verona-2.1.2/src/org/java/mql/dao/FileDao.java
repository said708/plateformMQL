package org.java.mql.dao;

import java.util.List;

import org.java.mql.dao.mediator.DAOservice;
import org.java.mql.models.File;


public interface FileDao extends DAOservice{
	int addFile(File file);
	File deleteFile(File file);
	List<File> selectAllFile();
	File selectFileById(long id);// Modified by YcDev, previous signature : List<File> selectFileById(long id); 
	int updateFile(File file);
}
