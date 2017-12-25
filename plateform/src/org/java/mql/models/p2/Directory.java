package org.java.mql.models.p2;

import java.util.List;
import java.util.Vector;

public class Directory extends AbstractFile{
	
	private Type type;
	private List<AbstractFile> files;

	public Directory() {
	}
	
	public Directory(long id, String name, String path , Type type) {
		super(id, name, path);
		this.files = new Vector<AbstractFile>();
		this.type = type;
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
