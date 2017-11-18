package org.java.mql.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DaoMediatorService {

	private DaoMediator mediator;

	
	
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

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
