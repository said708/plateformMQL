package org.java.mql.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DaoMediatorService {

	private DaoMediator mediator;

	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public DaoMediatorService() {
	}

	public DaoMediatorService(DaoMediator mediator) {
		this.mediator = mediator;
	}

	public DaoMediator getMediator() {
		return mediator;
	}

	public void setMediator(DaoMediator mediator) {
		this.mediator = mediator;
	}
	
	
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
		
	}

	public void persist(Object entity) {
		getSession().persist(entity);
	}

	public void delete(Object entity) {
		getSession().delete(entity);
	}
}
