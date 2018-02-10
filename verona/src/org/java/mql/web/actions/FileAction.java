package org.java.mql.web.actions;

import org.java.mql.business.Module2Business;
import org.java.mql.models.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


@Component
@RequestScope
public class FileAction {

	@Autowired
	private Module2Business business;

	@Autowired
	private File file;



	public FileAction() {
	}


	

	public Module2Business getBusiness() {
		return business;
	}




	public void setBusiness(Module2Business business) {
		this.business = business;
	}


	public File getFile() {
		return file;
	}




	public void setFile(File file) {
		this.file = file;
	}

	public void addFileToLiverable() {
		
	}

}
