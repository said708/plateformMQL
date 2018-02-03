package org.java.mql.web.actions;

import org.java.mql.business.Module2Business;
import org.java.mql.models.Liverable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


@Component
@RequestScope
public class LiverableAction {

	@Autowired
	private Module2Business business;

	@Autowired
	private Liverable liverable;



	public LiverableAction() {
	}


	public void setBusiness(Module2Business business) {
		this.business = business;
	}

	public Module2Business getBusiness() {
		return business;
	}




	public void setLiverable(Liverable liverable) {
		this.liverable = liverable;
	}


	public Liverable getLiverable() {
		return liverable;
	}


}
