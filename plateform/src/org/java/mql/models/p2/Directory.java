package org.java.mql.models.p2;

import java.util.List;

public class Directory extends AbstractFile{
	
	private Type type;
	private List<AbstractFile> files;

	public Directory() {
		// TODO Auto-generated constructor stub
	}
	
	public List<AbstractFile> getFiles() {
		return files;
	}

	public void setFiles(List<AbstractFile> files) {
		this.files = files;
	}
	
	public void add(AbstractFile file) {
		files.add(file);
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	
	
	
}
